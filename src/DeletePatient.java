import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DeletePatient {

//	Filing filing = new Filing();

	HashMap<String, Integer> columnMap = new HashMap<>();

	DeletePatient() {
		columnMap.put("fName", 0);
		columnMap.put("lName", 1);
		columnMap.put("gender", 2);
		columnMap.put("date", 3);
		columnMap.put("email", 4);
		columnMap.put("password", 5);
	}

	public ArrayList<String> deletePatientByEmail(ArrayList<String> arrayList, String email) {
		for (int i = 0; i < arrayList.size(); i++) {
			String lineInfo = arrayList.get(i);
//			System.out.println(lineInfo);
			if (lineInfo != null) {
				String[] columns = lineInfo.split(",");
//				System.out.println((columns[columnMap.get("email")]));
				if (columns[columnMap.get("email")].equals(email)) {
					arrayList.remove(i);
					break;
				}
			}
		}
		return arrayList;
	}

	public String arrayListToString(ArrayList<String> rows) {
		String rowsInString = "";
		for (int i = 0; i < rows.size(); i++) {
			rowsInString += rows.get(i) + "\n";
		}
		return rowsInString;

	}

}
