import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;

import javafx.collections.ObservableList;

public class Database {

	// Database connection details
	private static final String JDBC_URL = "jdbc:mysql://localhost:3308/hospitalManagementSystem";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	static String colName = "";
	String colData = "";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	}

	public static boolean isEmailUnique(String email) throws SQLException {
		try (Connection connection = getConnection()) {
			String checkQuery = "SELECT COUNT(*) FROM user WHERE email = ?";
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

			colName = "";

			for (int loop = columnNo; loop <= counter; loop++) {
				if (loop < counter) {
					colName = colName + md.getColumnLabel(loop) + ", ";
				} else {
					colName = colName + md.getColumnLabel(loop);
				}
//				System.out.println(colName);
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
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static ArrayList<String> getColDataFromDb(String tableName, String colName) throws SQLException {
		ArrayList<String> colData = new ArrayList<>();
		try (Connection connection = getConnection()) {
			String query = "SELECT " + colName + " FROM " + tableName;
			try (PreparedStatement preparedStatement = connection.prepareStatement(query);
					ResultSet resultSet = preparedStatement.executeQuery()) {

				while (resultSet.next()) {
					colData.add(resultSet.getString(colName));
				}
			}
		}
		return colData;
	}

	public static ArrayList<String> getConditioinalDataFromDb(String tableName, String colName, String conditionCol,
			String condition) throws SQLException {
		ArrayList<String> colData = new ArrayList<>();
		System.out.println("herer");
		try (Connection connection = getConnection()) {
			String query = "SELECT " + colName + " FROM " + tableName + " WHERE " + conditionCol + " = " + "\""
					+ condition + "\"";
//			String query = "SELECT " + colName + " FROM " + tableName + " WHERE " + conditionCol + " =  ahmedsilat95@gmail.com";
			System.out.println(query);
			try (PreparedStatement preparedStatement = connection.prepareStatement(query);
					ResultSet resultSet = preparedStatement.executeQuery()) {

				while (resultSet.next()) {
					colData.add(resultSet.getString(colName));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return colData;
	}

	public static void deleteRecord(String tableName, String primaryKeyColumnName, String primaryKeyValue) {
		try {
			Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

			String deleteQuery = "DELETE FROM " + tableName + " WHERE " + primaryKeyColumnName + " = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);

			preparedStatement.setString(1, primaryKeyValue);
			preparedStatement.executeUpdate();

			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String[] clearTextFields(String inputFields) {
		String arr[] = inputFields.split(" ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = "";
		}
		return arr;
	}

	public static String getErrorMessage(SQLException e) {
		if (e.getMessage().contains("Duplicate entry")) {
			return "Email is not unique";
		} else {
			return "Something get wrong";
		}
	}

}
