//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class PatientDataFiling {
//	private static final String appointmentFile = "appointments.txt";
//
////	HashMap<String, Integer> columnMap = new HashMap<>();
////
////	PatientDataFiling() {
////		columnMap.put("fName", 0);
////		columnMap.put("lName", 1);
////		columnMap.put("gender", 2);
////		columnMap.put("date", 3);
////		columnMap.put("email", 4);
////		columnMap.put("password", 5);
////	}
//
//	public void writeData(String data) {
//		try {
//			FileWriter fileWriter = new FileWriter(appointmentFile, true);
//			fileWriter.write(data + "\n");
//			fileWriter.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public ArrayList<String> readData() {
//		ArrayList<String> arrayList = new ArrayList<String>();
//		try {
//			BufferedReader reader;
//			reader = new BufferedReader(new FileReader(appointmentFile));
//			String line;
//			try {
//				line = reader.readLine();
//				while (line != null) {
//					arrayList.add(line);
//					line = reader.readLine();
//				}
//				reader.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		return arrayList;
//	}
//
////	public boolean searchByEmail(ArrayList<String> arrayList, String email) {
////		for (int i = 0; i < arrayList.size(); i++) {
////			String lineInfo = arrayList.get(i);
//////		System.out.println(lineInfo);
////			if (lineInfo != null) {
////				String[] columns = lineInfo.split(",");
//////			System.out.println((columns[columnMap.get("email")]));
////				if (columns[columnMap.get("email")].equals(email)) {
////					return true;
////				}
////			}
////		}
////		return false;
////	}
//}
