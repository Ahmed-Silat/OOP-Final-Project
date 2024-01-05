import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	// Database connection details
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hospitalManagementSystem";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	static String colName = "";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	}

	public static boolean isEmailUnique(String email) throws SQLException {
		try (Connection connection = getConnection()) {
			String checkQuery = "SELECT COUNT(*) FROM doctor WHERE email = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(checkQuery)) {
				preparedStatement.setString(1, email);
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					if (resultSet.next()) {
						int count = resultSet.getInt(1);
						return count == 0;
					}
				}
			}
		}
		return false;
	}

	public static String getColumnNames(String tableName, int columnNo) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs;
		try (Connection connection = getConnection()) {
			con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT *FROM " + tableName);
			ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
			int counter = md.getColumnCount();
			for (int loop = columnNo; loop <= counter; loop++) {
				if (loop < counter) {
					colName = colName + md.getColumnLabel(loop) + ", ";
				} else {
					colName = colName + md.getColumnLabel(loop);
				}
				System.out.println(colName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return colName;
	}

	public static void insertIntoDb(String data, String tableName) throws SQLException {

		String tableData[] = data.split(" ");

		String colNames = getColumnNames(tableName, 2);

		String colNamesArr[] = colNames.split(",");
		int arrLength = colNamesArr.length;
		String values = "";
		for (int i = 0; i < arrLength; i++) {
			if (i < arrLength - 1) {
				values = values + "?, ";
			} else {
				values = values + "?";
			}
		}

		try (Connection connection = getConnection()) {
			String insertQuery = "INSERT INTO " + tableName + " (" + colNames + ")" + "VALUES (" + values + ")";
			try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
				System.out.println(insertQuery);

				for (int i = 0; i < tableData.length; i++) {
					preparedStatement.setString(i + 1, tableData[i]);
				}
				preparedStatement.executeUpdate();
			}
		}
	}

	public static String getErrorMessage(SQLException e) {
		if (e.getMessage().contains("Duplicate entry")) {
			return "Email is not unique";
		} else {
			return "Email is not unique";
		}
	}

}
