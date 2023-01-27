import javafx.application.Application;
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

		TableColumn<Patients, String> col1 = new TableColumn<>("PatientID");
		col1.setCellValueFactory(new PropertyValueFactory<>("patientId"));

		TableColumn<Patients, String> col2 = new TableColumn<>("PatientName");
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

//		tableview.getItems().add(new Patients("1", "ahmed", "farooq", "male", "12322", "Ahmed"));
//		tableview.getItems().add(new Patients("2", "haseeb", "riaz", "male", "12322", "Shoaib"));
//		tableview.getItems().add(new Patients("3", "asad", "shoaib", "female", "12322", "Asad"));
//
//		VBox v = new VBox(10, tableview);

//		scene = new Scene(v, 1800, 980);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
