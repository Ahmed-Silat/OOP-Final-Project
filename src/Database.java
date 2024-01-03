import java.sql.*;

public class Database {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalManagementSystem",
					"root","");
			Statement stmt = con.createStatement();
			System.out.println("inserting records");
			String sql = "Insert into user values(2)";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
