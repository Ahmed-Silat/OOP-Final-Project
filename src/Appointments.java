import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Appointments extends Application {
	Scene scene;
	Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {

		stage = primaryStage;
		TableView<Patients> tableview = new TableView<>();
//
		TableColumn<Patients, String> col1 = new TableColumn<>("Patient ID");
		col1.setCellValueFactory(new PropertyValueFactory<>("patientId"));

		TableColumn<Patients, String> col2 = new TableColumn<>("Patient Name");
		col2.setCellValueFactory(new PropertyValueFactory<>("userName"));

		TableColumn<Patients, String> col3 = new TableColumn<>("FatherName");
		col3.setCellValueFactory(new PropertyValueFactory<>("fatherName"));

		TableColumn<Patients, String> col4 = new TableColumn<>("Gender");
		col4.setCellValueFactory(new PropertyValueFactory<>("gender"));

		TableColumn<Patients, String> col5 = new TableColumn<>("DOB");
		col5.setCellValueFactory(new PropertyValueFactory<>("DOB"));

		TableColumn<Patients, String> col6 = new TableColumn<>("DoctorName");
		col6.setCellValueFactory(new PropertyValueFactory<>("doctorName"));

		tableview.getColumns().add(col1);
		tableview.getColumns().add(col2);
		tableview.getColumns().add(col3);
		tableview.getColumns().add(col4);
		tableview.getColumns().add(col5);
		tableview.getColumns().add(col6);

		AppointmentDataValidation adv = new AppointmentDataValidation();
		Patients patients = new Patients();
//		if (adv.readData().equals(patients.email)) {
		ObservableList<Patients> oListStavaka;

		oListStavaka = FXCollections.observableArrayList();
		//
		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader("appointments.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (adv.readData().equals(parts[0])) {
					oListStavaka.add(new Patients(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]));
				}
			}

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tableview.setItems(oListStavaka);
//		}

//		ObservableList<Patients> oListStavaka;
//
//		oListStavaka = FXCollections.observableArrayList();
////
//		try {
//			BufferedReader reader;
//			reader = new BufferedReader(new FileReader("appointments.txt"));
//			String line;
//			while ((line = reader.readLine()) != null) {
//				String[] parts = line.split(",");
//				oListStavaka.add(new Patients(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]));
//			}
//
//			reader.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		tableview.setItems(oListStavaka);

		VBox v = new VBox(10, tableview);
		scene = new Scene(v, 1800, 980);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
