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

		// add patient box code
		Text textAddPatient = new Text();
		textAddPatient.setText("ADD \n PATIENT");
		textAddPatient.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		textAddPatient.setFill(Color.WHITE);
		textAddPatient.setTextAlignment(TextAlignment.CENTER);

		Image addPatientPic = new Image("images/addpatient-01.png");
		ImageView patientPic1 = new ImageView(addPatientPic);
		patientPic1.setFitHeight(50);
		patientPic1.setFitWidth(60);

		VBox addPatientVBox = new VBox(10, patientPic1, textAddPatient);
		addPatientVBox.setAlignment(Pos.CENTER);

		Button addPatientBtn = new Button();
		addPatientBtn.setCursor(Cursor.HAND);
		addPatientBtn.setPadding(new Insets(20, 60, 20, 60));
		addPatientBtn.setStyle(
				"-fx-background-color: #3E77B6;-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-width: 5;-fx-border-color: aqua");
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

		// delete patients box code
		Text textDeletePatient1 = new Text("DELETE \n PATIENT");
		textDeletePatient1.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		textDeletePatient1.setFill(Color.WHITE);
		textDeletePatient1.setTextAlignment(TextAlignment.CENTER);

		Image deletePatientPic1 = new Image("images/addpatient-01.png");
		ImageView deletepatientPic1 = new ImageView(deletePatientPic1);
		deletepatientPic1.setFitHeight(50);
		deletepatientPic1.setFitWidth(60);

		VBox deletePatientVBox1 = new VBox(10, deletepatientPic1, textDeletePatient1);
		deletePatientVBox1.setAlignment(Pos.CENTER);

		Button deletePatientBtn1 = new Button();
		deletePatientBtn1.setCursor(Cursor.HAND);
		deletePatientBtn1.setPadding(new Insets(20, 60, 20, 60));
		deletePatientBtn1.setStyle(
				"-fx-background-color: #3E77B6;-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-width: 5;-fx-border-color: aqua");
		deletePatientBtn1.setGraphic(deletePatientVBox1);

		DropShadow deletePatientDropShadow1 = new DropShadow();
		DropShadow deleteshade31 = new DropShadow();
		deletePatientBtn1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				deletePatientBtn1.setEffect(deletePatientDropShadow1);
			}
		});
		deletePatientBtn1.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				deletePatientBtn1.setEffect(null);
			}
		});

		deletePatientBtn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				DeletePatient deletePatient = new DeletePatient();
				try {
					deletePatient.start(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// add doctors box code
		Text textAddDoctors = new Text("ADD \n DOCTORS");
		textAddDoctors.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		textAddDoctors.setFill(Color.WHITE);
		textAddDoctors.setTextAlignment(TextAlignment.CENTER);

		Image addDoctorPic = new Image("images/general-01.png");
		ImageView addDoctorPic1 = new ImageView(addDoctorPic);
		addDoctorPic1.setFitHeight(50);
		addDoctorPic1.setFitWidth(60);

		VBox addDoctorVBox = new VBox(10, addDoctorPic1, textAddDoctors);
		addDoctorVBox.setAlignment(Pos.CENTER);

		Button addDoctorBtn = new Button();
		addDoctorBtn.setCursor(Cursor.HAND);
		addDoctorBtn.setPadding(new Insets(20, 50, 20, 50));
		addDoctorBtn.setStyle(
				"-fx-background-color: #3E77B6;-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-width: 5;-fx-border-color: aqua");
		addDoctorBtn.setGraphic(addDoctorVBox);

		DropShadow addDoctorDropShadow = new DropShadow();
		DropShadow shade4 = new DropShadow();
		addDoctorBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				addDoctorBtn.setEffect(addDoctorDropShadow);
			}
		});
		addDoctorBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				addDoctorBtn.setEffect(null);
			}
		});

		addDoctorBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				AddDoctor addPatient = new AddDoctor();
				try {
					addPatient.start(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// delete doctor box code
		Text textDeleteDoctor = new Text("DELETE \n DOCTOR");
		textDeleteDoctor.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		textDeleteDoctor.setFill(Color.WHITE);
		textDeleteDoctor.setTextAlignment(TextAlignment.CENTER);

		Image deleteDoctorPic = new Image("images/general-01.png");
		ImageView delDoctorPic2 = new ImageView(deleteDoctorPic);
		delDoctorPic2.setFitHeight(50);
		delDoctorPic2.setFitWidth(60);

		VBox deleteDoctorVBox = new VBox(10, delDoctorPic2, textDeleteDoctor);
		deleteDoctorVBox.setAlignment(Pos.CENTER);

		Button deleteDoctorBtn = new Button();
		deleteDoctorBtn.setCursor(Cursor.HAND);
		deleteDoctorBtn.setPadding(new Insets(20, 50, 20, 50));
		deleteDoctorBtn.setStyle(
				"-fx-background-color: #3E77B6;-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-width: 5;-fx-border-color: aqua");
		deleteDoctorBtn.setGraphic(deleteDoctorVBox);

		deleteDoctorBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				DeleteDoctor deleteDoctor = new DeleteDoctor();
				try {
					deleteDoctor.start(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		DropShadow deleteDoctorDropShadow = new DropShadow();
		DropShadow shade5 = new DropShadow();
		deleteDoctorBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				deleteDoctorBtn.setEffect(deleteDoctorDropShadow);
			}
		});
		deleteDoctorBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				deleteDoctorBtn.setEffect(null);
			}
		});

		// add appointment
		Text textAddAppointment = new Text("ADD \n APPOINTMENT");
		textAddAppointment.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		textAddAppointment.setFill(Color.WHITE);
		textAddAppointment.setTextAlignment(TextAlignment.CENTER);

		Image addAppointmentPic1 = new Image("images/Appoinment-01.png");
		ImageView addAppointmentPic2 = new ImageView(addAppointmentPic1);
		addAppointmentPic2.setFitHeight(50);
		addAppointmentPic2.setFitWidth(60);

		VBox addAppointmentVBox1 = new VBox(10, addAppointmentPic2, textAddAppointment);
		addAppointmentVBox1.setAlignment(Pos.CENTER);

		Button addAppointmentBtn1 = new Button();
		addAppointmentBtn1.setCursor(Cursor.HAND);
		addAppointmentBtn1.setPadding(new Insets(20, 40, 20, 40));
		addAppointmentBtn1.setStyle(
				"-fx-background-color: #3E77B6;-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-width: 5;-fx-border-color: aqua");
		addAppointmentBtn1.setGraphic(addAppointmentVBox1);

		addAppointmentBtn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				AddAppointment addAppointment = new AddAppointment();
				try {
					addAppointment.start(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		DropShadow addAppointmentDropShadow1 = new DropShadow();
		DropShadow shade6 = new DropShadow();
		addAppointmentBtn1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				addAppointmentBtn1.setEffect(addAppointmentDropShadow1);
			}
		});
		addAppointmentBtn1.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				addAppointmentBtn1.setEffect(null);
			}
		});

		// delete appointment
		Text textDeleteAppointment1 = new Text("DELETE \n APPOINTMENT");
		textDeleteAppointment1.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		textDeleteAppointment1.setFill(Color.WHITE);
		textDeleteAppointment1.setTextAlignment(TextAlignment.CENTER);

		Image deleteAppointmentPic1 = new Image("images/Appoinment-01.png");
		ImageView deleteAppointmentPic2 = new ImageView(deleteAppointmentPic1);
		deleteAppointmentPic2.setFitHeight(50);
		deleteAppointmentPic2.setFitWidth(60);

		VBox deleteAppointmentVBox1 = new VBox(10, deleteAppointmentPic2, textDeleteAppointment1);
		deleteAppointmentVBox1.setAlignment(Pos.CENTER);

		Button deleteAppointmentBtn1 = new Button();
		deleteAppointmentBtn1.setCursor(Cursor.HAND);
		deleteAppointmentBtn1.setPadding(new Insets(20, 40, 20, 40));
		deleteAppointmentBtn1.setStyle(
				"-fx-background-color: #3E77B6;-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-width: 5;-fx-border-color: aqua");
		deleteAppointmentBtn1.setGraphic(deleteAppointmentVBox1);

		deleteAppointmentBtn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				DeleteAppointment deleteAppointment = new DeleteAppointment();
				try {
					deleteAppointment.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		DropShadow deleteAppointmentDropShadow1 = new DropShadow();
		DropShadow shade7 = new DropShadow();
		deleteAppointmentBtn1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				deleteAppointmentBtn1.setEffect(deleteAppointmentDropShadow1);
			}
		});
		deleteAppointmentBtn1.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				deleteAppointmentBtn1.setEffect(null);
			}
		});

		// addPharmacy
		Text textAddPharmacy = new Text("ADD \n PHARMACY");
		textAddPharmacy.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		textAddPharmacy.setFill(Color.WHITE);
		textAddPharmacy.setTextAlignment(TextAlignment.CENTER);

		Image addPharmacyPic1 = new Image("images/pharmacyyy-01.png");
		ImageView addPharmacyPic2 = new ImageView(addPharmacyPic1);
		addPharmacyPic2.setFitHeight(50);
		addPharmacyPic2.setFitWidth(60);

		VBox addPharmacyVBox1 = new VBox(10, addPharmacyPic2, textAddPharmacy);
		addPharmacyVBox1.setAlignment(Pos.CENTER);

		Button addPharmacyBtn1 = new Button();
		addPharmacyBtn1.setCursor(Cursor.HAND);
		addPharmacyBtn1.setPadding(new Insets(20, 40, 20, 40));
		addPharmacyBtn1.setStyle(
				"-fx-background-color: #3E77B6;-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-width: 5;-fx-border-color: aqua");
		addPharmacyBtn1.setGraphic(addPharmacyVBox1);

		addPharmacyBtn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
//				DeletePatientUI deletePatient = new DeletePatientUI();
				try {
//					deletePatient.start(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		DropShadow addPharmacyDropShadow1 = new DropShadow();
		DropShadow shade8 = new DropShadow();
		addPharmacyBtn1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				addPharmacyBtn1.setEffect(addPharmacyDropShadow1);
			}
		});
		addPharmacyBtn1.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				addPharmacyBtn1.setEffect(null);
			}
		});

		// deletepharmacy
		Text textDeletePharmacy1 = new Text("DELETE \n PHARMACY");
		textDeletePharmacy1.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		textDeletePharmacy1.setFill(Color.WHITE);
		textDeletePharmacy1.setTextAlignment(TextAlignment.CENTER);

		Image deletePharmacyPic1 = new Image("images/pharmacyyy-01.png");
		ImageView deletePharmacyPic2 = new ImageView(deletePharmacyPic1);
		deletePharmacyPic2.setFitHeight(50);
		deletePharmacyPic2.setFitWidth(60);

		VBox deletePharmacyVBox1 = new VBox(10, deletePharmacyPic2, textDeletePharmacy1);
		deletePharmacyVBox1.setAlignment(Pos.CENTER);

		Button deletePharmacyBtn1 = new Button();
		deletePharmacyBtn1.setCursor(Cursor.HAND);
		deletePharmacyBtn1.setPadding(new Insets(20, 40, 20, 40));
		deletePharmacyBtn1.setStyle(
				"-fx-background-color: #3E77B6;-fx-background-radius: 20px;-fx-border-radius: 20px;-fx-border-width: 5;-fx-border-color: aqua");
		deletePharmacyBtn1.setGraphic(deletePharmacyVBox1);

		deletePharmacyBtn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
//				DeletePatientUI deletePatient = new DeletePatientUI();
				try {
//					deletePatient.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		DropShadow deletePharmacyDropShadow1 = new DropShadow();
		DropShadow shade9 = new DropShadow();
		deletePharmacyBtn1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				deletePharmacyBtn1.setEffect(deletePharmacyDropShadow1);
			}
		});
		deletePharmacyBtn1.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				deletePharmacyBtn1.setEffect(null);
			}
		});

		// logout Button box code
		Button logoutBtn = new Button("LOGOUT");
		logoutBtn.setCursor(Cursor.HAND);
		logoutBtn.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		logoutBtn.setTextFill(Color.WHITE);
		logoutBtn.setStyle("-fx-background-color: #8EA7E9; -fx-background-radius: 20px;");
		logoutBtn.setPadding(new Insets(20, 20, 20, 20));
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

		HBox l1 = new HBox(10, addPatientBtn, addDoctorBtn, addAppointmentBtn1, addPharmacyBtn1);
		l1.setAlignment(Pos.CENTER);
		l1.setMargin(l1, new Insets(40, 0, 40, 0));

		HBox l2 = new HBox(10, deletePatientBtn1, deleteDoctorBtn, deleteAppointmentBtn1, deletePharmacyBtn1);
		l2.setAlignment(Pos.CENTER);
		l2.setMargin(l2, new Insets(40, 0, 40, 0));

		HBox logout = new HBox(logoutBtn);
		logout.setAlignment(Pos.CENTER);
		logout.setMargin(logoutBtn, new Insets(5, 0, 0, 3));

		VBox layout = new VBox(10, mainHeading, l1, l2, logout);

		layout.setStyle("-fx-background-color:#2B7490");
		layout.setAlignment(Pos.CENTER);
		scene = new Scene(layout, 1800, 980);
		stage.setTitle("Admin Dashboard");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();

	}

}
