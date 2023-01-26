import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.control.Alert;

public class AdminAuthentication {
	private static final String adminFile = "admin.txt";

	HashMap<String, Integer> columnMap = new HashMap<>();

	AdminAuthentication() {
		columnMap.put("fName", 0);
		columnMap.put("lName", 1);
		columnMap.put("gender", 2);
		columnMap.put("date", 3);
		columnMap.put("email", 4);
		columnMap.put("password", 5);
	}

	public boolean searchByEmailAndPassword(ArrayList<String> arrayList, String email, String password) {
		for (int i = 0; i < arrayList.size(); i++) {
			String lineInfo = arrayList.get(i);
//			System.out.println(lineInfo);
			if (lineInfo != null) {
				String[] columns = lineInfo.split(",");
//				System.out.println((columns[columnMap.get("email")]));
				if (columns[columnMap.get("email")].equals(email)
						&& columns[columnMap.get("password")].equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

	Filing filing = new Filing();

	public boolean signIn(String emial, String Password) {
		ArrayList<String> usersFileData = filing.readData(adminFile);
		Boolean isEmailAndPasswordFound = searchByEmailAndPassword(usersFileData, emial, Password);
		if (isEmailAndPasswordFound == true) {
			Alert loginSuccessful = new Alert(Alert.AlertType.INFORMATION);
			loginSuccessful.setContentText("You are successfully Login");
			loginSuccessful.show();
			return true;
		} else {
			Alert loginError = new Alert(Alert.AlertType.ERROR);
			loginError.setContentText("Invalid Email or Password");
			loginError.show();
			return false;
		}
	}

}
