import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Cardiologist extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	Stage stage;
	Scene scene;
//	TextField txt_patient, txt_name, txt_father;
//	RadioButton rb_male, rb_female;
//	DatePicker dob;
	ComboBox<String> dr_names;
	TextArea txt_disease;
//	Patients patient;

//	LoginUI login = new LoginUI();

//	AppointmentDataValidation adv = new AppointmentDataValidation();

//	public Patients patientData() {
//		patient.setEmail(adv.readData());

//		patient.setPatientId(txt_patient.getText());
////		System.out.println(txt_patient.getText());
//		patient.setUserName(txt_name.getText());
//		patient.setFatherName(txt_father.getText());
//		if (rb_male.isSelected()) {
//			patient.setGender("Male");
//		} else if (rb_female.isSelected()) {
//			patient.setGender("Female");
//		}
//		patient.setDOB(dob.getValue().toString());
//		patient.setDoctorName(dr_names.getValue().toString());
//		patient.setDisease(txt_disease.getText());
//		return patient;
//	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		stage = primaryStage;
		stage.setTitle("Book An Appointment");
//		patient = new Patients();

		Text mainHeading = new Text();
		mainHeading.setText("CARDIOLOGIST\n");
		mainHeading.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
		mainHeading.setFill(Color.WHITESMOKE);

//		Label lbl_patient = new Label("Patient ID");
//		lbl_patient.setTextFill(Color.WHITE);
//		lbl_patient.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
//		txt_patient = new TextField();
//		txt_patient.setPromptText("Enter Patient ID");

//		Label lbl_name = new Label("Name");
//		lbl_name.setTextFill(Color.WHITE);
//		lbl_name.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
//		txt_name = new TextField();
//		txt_name.setPromptText("Enter Your Name");

//		Label lbl_father = new Label("Father Name");
//		lbl_father.setTextFill(Color.WHITE);
//		lbl_father.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
//		txt_father = new TextField();
//		txt_father.setPromptText("Enter Father Name");

//		Label lbl_gender = new Label("Gender");
//		lbl_gender.setTextFill(Color.WHITE);
//		lbl_gender.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
//		ToggleGroup rb_gp = new ToggleGroup();
//		rb_male = new RadioButton("Male");
//		rb_female = new RadioButton("Female");
//		rb_male.setToggleGroup(rb_gp);
//		rb_female.setToggleGroup(rb_gp);
//		rb_male.setTextFill(Color.WHITE);
//		rb_male.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
//		rb_female.setTextFill(Color.WHITE);
//		rb_female.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));

//		Label lbl_date = new Label("Date of Birth");
//		lbl_date.setTextFill(Color.WHITE);
//		lbl_date.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
//		dob = new DatePicker();
//		dob.setPromptText("Enter DOB");

//		Label lbl_ptName = new Label(UserAuthentication.patientName());
//		lbl_ptName.setTextFill(Color.WHITE);
//		lbl_ptName.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));

		Label lbl_doctor = new Label("Doctor Name");
		lbl_doctor.setTextFill(Color.WHITE);
		lbl_doctor.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
		dr_names = new ComboBox<>();
		dr_names.setPromptText("Select Doctor");
		dr_names.getItems().add("Dr. Ali Haider Naqvi");
		dr_names.getItems().add("Dr. Asif Mahmood");
		dr_names.getItems().add("Dr. Samiullah Khan");
		dr_names.getItems().add("Dr. Rameez Ahmed");
		dr_names.getSelectionModel().getSelectedItem();

		Label lbl_disease = new Label("Disease History");
		lbl_disease.setTextFill(Color.WHITE);
		lbl_disease.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
		txt_disease = new TextArea();
		txt_disease.setPromptText("Enter Your Disease");

//		HBox h1 = new HBox(75, lbl_patient, txt_patient);
//		HBox h2 = new HBox(115, lbl_name, txt_name);
//		HBox h3 = new HBox(45, lbl_father, txt_father);
//		HBox h4 = new HBox(98, lbl_gender, rb_male, rb_female);
//		h4.setMargin(rb_male, new Insets(-3, 0, 5, 0));
//		h4.setMargin(rb_female, new Insets(-3, 0, 5, -80));
//		HBox h5 = new HBox(50, lbl_ptName);
		HBox h6 = new HBox(45, lbl_doctor, dr_names);

		VBox points = new VBox(40, h6);
		VBox disease = new VBox(30, lbl_disease, txt_disease);

		HBox h = new HBox(25, points, disease);
		h.setMargin(disease, new Insets(0, 0, 0, 150));
		h.setAlignment(Pos.CENTER);

		HBox heading = new HBox(50, mainHeading);
		heading.setAlignment(Pos.CENTER);

		// save Button
		Button saveBtn = new Button("Book Appointment");
		saveBtn.setCursor(Cursor.HAND);
		HBox save = new HBox(saveBtn);
		saveBtn.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		saveBtn.setTextFill(Color.WHITE);
		saveBtn.setStyle("-fx-background-color: blue;-fx-background-radius: 20px;");
		saveBtn.setPadding(new Insets(10, 40, 10, 40));

		DropShadow shadowsave = new DropShadow();
		saveBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				saveBtn.setEffect(shadowsave);
			}
		});
		saveBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				saveBtn.setEffect(null);
			}
		});

		// cancel button
		Button cancelBtn = new Button("Cancel");
		cancelBtn.setCursor(Cursor.HAND);
		HBox cancel = new HBox(cancelBtn);
		cancelBtn.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		cancelBtn.setTextFill(Color.WHITE);
		cancelBtn.setStyle("-fx-background-color: red;-fx-background-radius: 20px;");
		cancelBtn.setPadding(new Insets(10, 30, 10, 30));

		cancelBtn.setOnAction(new EventHandler<ActionEvent>() {

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

		DropShadow shadowcancel = new DropShadow();
		cancelBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				cancelBtn.setEffect(shadowcancel);
			}
		});
		cancelBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				cancelBtn.setEffect(null);
			}
		});

		HBox buttons = new HBox(20, saveBtn, cancelBtn);
		buttons.setAlignment(Pos.CENTER);
		buttons.setMargin(saveBtn, new Insets(50, 2, 0, 0));
		buttons.setMargin(cancelBtn, new Insets(50, 0, 0, 0));

		// back button
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

		VBox mainVBox = new VBox(backBtn, heading, h, buttons);

		saveBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					String info = "";
					String gender = "";

//					info = "Patient ID: " + txt_patient.getText() + "\n";
//					info += "Patient Name: " + txt_name.getText() + "\n";
//					info += "Father Name: " + txt_father.getText() + "\n";

//					if (rb_male.isSelected()) {
//						gender = "Male";
//					} else if (rb_female.isSelected()) {
//						gender = "Female";
//					} else {
//						gender = "";
//					}

//					info += "Gender: " + gender + "\n";
//
//					info += "Date Of Birth: " + dob.getValue() + "\n";

					info += "Doctor: " + dr_names.getSelectionModel().getSelectedItem() + "\n";

					info += "Disease History: " + txt_disease.getText();

//					info += "doctor fees:  500";

					if (txt_disease.getText().equals("")) {
						Alert nullError = new Alert(Alert.AlertType.ERROR);
						nullError.setContentText("Fill out the Disease History Field");
						nullError.show();
					} else {

						Alert a = new Alert(AlertType.INFORMATION);
						a.setContentText("Your appointment has been booked successfully!\n\n" + info);
						a.show();

//						PatientDataFiling pdf = new PatientDataFiling();
//					System.out.println("coming here");
//						patientData();
//						pdf.writeData(patient.toString());
//					System.out.println(patient.toString());
					}

				} catch (Exception e) {
					Alert infoError = new Alert(Alert.AlertType.ERROR);
					infoError.setContentText("Fill out All the Fields");
					infoError.show();
				}

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

		mainVBox.setStyle("-fx-background-color: #2B7490");

		scene = new Scene(mainVBox, 1800, 980);
//		stage.setMaximized(true);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
}