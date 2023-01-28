import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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

		Button backBtn = new Button("Go Back");
		backBtn.setCursor(Cursor.HAND);
		HBox goBack = new HBox(backBtn);
		backBtn.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		backBtn.setTextFill(Color.WHITE);
		backBtn.setStyle("-fx-background-color: blue; -fx-background-radius: 20px;");
		backBtn.setPadding(new Insets(0, 20, 0, 20));
		goBack.setMargin(backBtn, new Insets(5, 0, 0, 3));

		DropShadow shadowback = new DropShadow();
		backBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				backBtn.setEffect(shadowback);
			}
		});
		backBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				backBtn.setEffect(null);
			}
		});

		backBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				UserDashboard userDashboard = new UserDashboard();
				try {
					userDashboard.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		VBox v = new VBox(10, goBack, tableview);
		scene = new Scene(v, 1800, 980);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
