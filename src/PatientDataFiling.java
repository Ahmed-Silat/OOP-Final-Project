import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PatientDataFiling {
	private static final String appointmentFile = "appointments.txt";

	public void writeData(String data) {
		try {
			FileWriter fileWriter = new FileWriter(appointmentFile, true);
			fileWriter.write(data + "\n");
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> readData() {
		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(appointmentFile));
			String line;
			try {
				line = reader.readLine();
				while (line != null) {
					arrayList.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return arrayList;
	}
}
