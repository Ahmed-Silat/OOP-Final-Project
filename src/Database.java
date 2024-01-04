import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    // Database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hospitalManagementSystem";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

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

    public static void insertDoctor(String firstName, String lastName, String gender, String dob, String email, String password, String specialization)
            throws SQLException {
         
        if (!isEmailUnique(email)) {
            throw new SQLException("Email is not unique");
        }

        try (Connection connection = getConnection()) {
            String insertQuery = "INSERT INTO doctor (first_name, last_name, gender, dob, email, password, specialization) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, gender);
                preparedStatement.setString(4, dob);
                preparedStatement.setString(5, email);
                preparedStatement.setString(6, password);
                preparedStatement.setString(7, specialization);

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
