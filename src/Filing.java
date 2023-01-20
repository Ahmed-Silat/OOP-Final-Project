import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Filing {

	public void writeData(String data, String fileName) {
		try {
			FileWriter fileWriter = new FileWriter(fileName, true);
			fileWriter.write(data + "\n");
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> readData(String fileName) {
		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(fileName));
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
