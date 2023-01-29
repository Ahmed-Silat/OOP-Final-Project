import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class AdminDashboard extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	Stage stage;
	Scene scene;
	Rectangle drRect;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;

		Text mainHeading = new Text();
		mainHeading.setText("WELCOME TO ADMIN PANEL\n");
		mainHeading.setFont(Font.font("Helvetica", FontWeight.BOLD, 60));
		mainHeading.setFill(Color.WHITE);

		// add doctor box code
//		Text textAddDoctor = new Text("ADD DOCTOR");
//		textAddDoctor.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 30));
//		textAddDoctor.setFill(Color.WHITE);
//
//		Image addDoctorPic = new Image("images/add-doctor.png");
//		ImageView doctorPic1 = new ImageView(addDoctorPic);
//		doctorPic1.setFitHeight(50);
//		doctorPic1.setFitWidth(60);
//
//		VBox addDoctorVBox = new VBox(10, doctorPic1, textAddDoctor);
//		addDoctorVBox.setAlignment(Pos.CENTER);
//
//		Button addDoctorBtn = new Button();
//		addDoctorBtn.setCursor(Cursor.HAND);
//		addDoctorBtn.setPadding(new Insets(58, 60, 58, 60));
//		addDoctorBtn.setStyle(
//				"-fx-background-color: #007AA2;-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-width: 5;-fx-border-color: aqua");
//		addDoctorBtn.setGraphic(addDoctorVBox);
//
//		DropShadow addDoctDropShadow = new DropShadow();
//		DropShadow shade1 = new DropShadow();
//		addDoctorBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent event) {
//				addDoctorBtn.setEffect(addDoctDropShadow);
//			}
//		});
//		addDoctorBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				addDoctorBtn.setEffect(null);
//			}
//		});
//
//		// delete doctor box code
//		Text textDeleteDoctor = new Text("DELETE DOCTOR");
//		textDeleteDoctor.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 30));
//		textDeleteDoctor.setFill(Color.WHITE);
//
//		Image deleteDoctorPic = new Image("images/add-doctor.png");
//		ImageView doctorPic2 = new ImageView(deleteDoctorPic);
//		doctorPic2.setFitHeight(50);
//		doctorPic2.setFitWidth(60);
//
//		VBox deleteDoctorVBox = new VBox(10, doctorPic2, textDeleteDoctor);
//		deleteDoctorVBox.setAlignment(Pos.CENTER);
//
//		Button deleteDoctorBtn = new Button();
//		deleteDoctorBtn.setCursor(Cursor.HAND);
//		deleteDoctorBtn.setPadding(new Insets(58, 60, 58, 60));
//		deleteDoctorBtn.setStyle(
//				"-fx-background-color: #009DCF;-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-width: 5;-fx-border-color: aqua");
//		deleteDoctorBtn.setGraphic(deleteDoctorVBox);
//
//		DropShadow deleteDoctDropShadow = new DropShadow();
//		DropShadow shade2 = new DropShadow();
//		deleteDoctorBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent event) {
//				deleteDoctorBtn.setEffect(deleteDoctDropShadow);
//			}
//		});
//		deleteDoctorBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				deleteDoctorBtn.setEffect(null);
//			}
//		});

		// add patient box code
		Text textAddPatient = new Text("ADD PATIENT");
		textAddPatient.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 30));
		textAddPatient.setFill(Color.WHITE);

		Image addPatientPic = new Image("images/addpatient-01.png");
		ImageView patientPic1 = new ImageView(addPatientPic);
		patientPic1.setFitHeight(50);
		patientPic1.setFitWidth(60);

		VBox addPatientVBox = new VBox(10, patientPic1, textAddPatient);
		addPatientVBox.setAlignment(Pos.CENTER);

		Button addPatientBtn = new Button();
		addPatientBtn.setCursor(Cursor.HAND);
		addPatientBtn.setPadding(new Insets(58, 60, 58, 60));
		addPatientBtn.setStyle(
				"-fx-background-color: #006A89;-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-width: 5;-fx-border-color: aqua");
		addPatientBtn.setGraphic(addPatientVBox);

		DropShadow addPatientDropShadow = new DropShadow();
		DropShadow shade3 = new DropShadow();
		addPatientBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				addPatientBtn.setEffect(addPatientDropShadow);
			}
		});
		addPatientBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				addPatientBtn.setEffect(null);
			}
		});

		addPatientBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				AddPatient addPatient = new AddPatient();
				try {
					addPatient.start(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// delete patient box code
		Text textDeletePatient = new Text("DELETE PATIENT");
		textDeletePatient.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 30));
		textDeletePatient.setFill(Color.WHITE);

		Image deletePatientPic = new Image("images/addpatient-01.png");
		ImageView patientPic2 = new ImageView(deletePatientPic);
		patientPic2.setFitHeight(50);
		patientPic2.setFitWidth(60);

		VBox deletePatientVBox = new VBox(10, patientPic2, textDeletePatient);
		deletePatientVBox.setAlignment(Pos.CENTER);

		Button deletePatientBtn = new Button();
		deletePatientBtn.setCursor(Cursor.HAND);
		deletePatientBtn.setPadding(new Insets(58, 60, 58, 60));
		deletePatientBtn.setStyle(
				"-fx-background-color: #3E77B6;-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-width: 5;-fx-border-color: aqua");
		deletePatientBtn.setGraphic(deletePatientVBox);

		DropShadow deletePatientDropShadow = new DropShadow();
		DropShadow shade4 = new DropShadow();
		deletePatientBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				deletePatientBtn.setEffect(deletePatientDropShadow);
			}
		});
		deletePatientBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				deletePatientBtn.setEffect(null);
			}
		});

		// logout Button box code
		Button logoutBtn = new Button("LOGOUT");
		logoutBtn.setCursor(Cursor.HAND);
		logoutBtn.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		logoutBtn.setTextFill(Color.WHITE);
		logoutBtn.setStyle("-fx-background-color: #8EA7E9; -fx-background-radius: 20px;");
		logoutBtn.setPadding(new Insets(10, 15, 10, 15));
		logoutBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				LoginUI login = new LoginUI();
				try {
					login.start(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		DropShadow shadowback = new DropShadow();
		logoutBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				logoutBtn.setEffect(shadowback);
			}
		});
		logoutBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				logoutBtn.setEffect(null);
			}
		});

//		HBox doctors = new HBox(20, addDoctorBtn, deleteDoctorBtn);
//		doctors.setAlignment(Pos.CENTER);
		HBox patients = new HBox(20, addPatientBtn, deletePatientBtn);
		patients.setAlignment(Pos.CENTER);
		patients.setMargin(addPatientBtn, new Insets(40, 0, 40, 0));
		HBox logout = new HBox(logoutBtn);
		logout.setAlignment(Pos.CENTER);
		logout.setMargin(logoutBtn, new Insets(5, 0, 0, 3));

		VBox layout = new VBox(10, mainHeading, patients, logout);
		layout.setStyle("-fx-background-color:#2B7490");
		layout.setAlignment(Pos.CENTER);
		scene = new Scene(layout, 1800, 980);
		stage.setTitle("Admin Dashboard");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();

	}

}
