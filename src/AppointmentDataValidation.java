//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class AppointmentDataValidation {
//	private static final String userEmailFile = "loggedIn.txt";
//
//	public void writeData(String data) {
//		try {
//			FileWriter fileWriter = new FileWriter(userEmailFile);
//			fileWriter.write(data + "\n");
//			fileWriter.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public String readData() {
//		ArrayList<String> arrayList = new ArrayList<String>();
//		try {
//			BufferedReader reader;
//			reader = new BufferedReader(new FileReader(userEmailFile));
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
//		return arrayList.get(0);
//	}
//}
