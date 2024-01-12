//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.regex.Pattern;
//
//import javafx.scene.control.Alert;
//
//public class UserAuthentication {
//	private static final String usersFile = "signup.txt";
//
//	HashMap<String, Integer> columnMap = new HashMap<>();
//
//	UserAuthentication() {
//		columnMap.put("fName", 0);
//		columnMap.put("lName", 1);
//		columnMap.put("gender", 2);
//		columnMap.put("date", 3);
//		columnMap.put("email", 4);
//		columnMap.put("password", 5);
//	}
//
//	public boolean searchByEmail(ArrayList<String> arrayList, String email) {
//		for (int i = 0; i < arrayList.size(); i++) {
//			String lineInfo = arrayList.get(i);
////			System.out.println(lineInfo);
//			if (lineInfo != null) {
//				String[] columns = lineInfo.split(",");
////				System.out.println((columns[columnMap.get("email")]));
//				if (columns[columnMap.get("email")].equals(email)) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//
//	public boolean searchByEmailAndPassword(ArrayList<String> arrayList, String email, String password) {
//		for (int i = 0; i < arrayList.size(); i++) {
//			String lineInfo = arrayList.get(i);
////			System.out.println(lineInfo);
//			if (lineInfo != null) {
//				String[] columns = lineInfo.split(",");
////				System.out.println((columns[columnMap.get("email")]));
//				if (columns[columnMap.get("email")].equals(email)
//						&& columns[columnMap.get("password")].equals(password)) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//
//	Filing filing = new Filing();
//
//	public boolean signUp(User userData) {
//		ArrayList<String> usersFileData = filing.readData(usersFile);
//		Boolean isEmailFound = searchByEmail(usersFileData, userData.getEmail());
//		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
//
//		Pattern pattern = Pattern.compile(emailRegex);
//		if (isEmailFound == true) {
//			Alert signUpError = new Alert(Alert.AlertType.ERROR);
//			signUpError.setContentText("Email already exist");
////			System.out.println("Email already exist");
//			signUpError.show();
//			return false;
//		}
//		if (!pattern.matcher(userData.getEmail()).matches()) {
//			Alert emailError = new Alert(Alert.AlertType.ERROR);
//			emailError.setContentText("Invalid Email");
//			emailError.show();
//			return false;
//		} else {
////			password match validation usersFileData,pass1,pass2
//			if (userData.getPassword().equals(userData.getConfirmPassword())) {
//				filing.writeData(userData.toString(), usersFile);
//				Alert signUpSuccessful = new Alert(Alert.AlertType.INFORMATION);
//				signUpSuccessful.setContentText("You have successfully created Your Account");
//				signUpSuccessful.show();
//				return true;
//			} else {
//				Alert signUpError = new Alert(Alert.AlertType.ERROR);
//				signUpError.setContentText("Password doesn't match");
//				signUpError.show();
//				return false;
//			}
//		}
//	}
//
//	public boolean signIn(String emial, String Password) {
//		ArrayList<String> usersFileData = filing.readData(usersFile);
//		Boolean isEmailAndPasswordFound = searchByEmailAndPassword(usersFileData, emial, Password);
//		if (isEmailAndPasswordFound == true) {
//			Alert loginSuccessful = new Alert(Alert.AlertType.INFORMATION);
//			loginSuccessful.setContentText("You are successfully Login");
//			loginSuccessful.show();
//			return true;
////			UserDashboard userDashboard = new UserDashboard();
////			userDashboard.start();
//		} else {
//			Alert loginError = new Alert(Alert.AlertType.ERROR);
//			loginError.setContentText("Invalid Email or Password");
//			loginError.show();
//			return false;
//		}
//	}
//
//}

import java.sql.SQLException;
import java.util.ArrayList;

public class UserAuthentication {

	public static boolean isEmailUnique(String email) throws SQLException {
		ArrayList<String> emails = Database.getColDataFromDb("user", "email");

		for (int i = 0; i < emails.size(); i++) {
			if (emails.get(i).equals(email)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPasswordCorrect(String email, String password) throws SQLException {
		ArrayList<String> userData = Database.getConditioinalDataFromDb("user", "password", "email", email);

		for (int i = 0; i < userData.size(); i++) {
			System.out.println(userData.get(i));
			if (userData.get(i).equals(password)) {
				System.out.println("password Found");
				return true;
			}
		}
		return false;
	}
	
	 public static String getUsername(String email) throws SQLException {
	        ArrayList<String> userData = Database.getConditioinalDataFromDb("user", "first_name", "email", email);

	        if (!userData.isEmpty()) {
	            return userData.get(0);
	        }

	        return null;
	    }
}
