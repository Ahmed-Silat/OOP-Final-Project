
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddAppointment extends Application {

	Scene signUpScene;
	Stage stage;
	TextField txt_ptName, txt_disease;
	ComboBox<String> cmb_email;
	ComboBox<String> cmb_consultant;
	ComboBox<String> cmb_docName;
//	RadioButton rb_male, rb_female;
//	ComboBox<Integer> cmb_date;
//	ComboBox<String> cmb_month, cmb_year;
//	PasswordField pass, rePass;
	

//	public String getDoctorDetails() {
//		String firstName = txt_fName.getText();
//		String lastName = txt_lName.getText();
//		String gender = rb_male.isSelected() ? "Male" : "Female";
//		String dob = cmb_year.getValue() + "-" + (cmb_month.getSelectionModel().getSelectedIndex() + 1) + "-"
//				+ cmb_date.getValue();
//		String email = txt_email.getText();
//		String password = pass.getText();
//		String specialization = cmb_specialization.getValue();

//		return firstName + " " + lastName + " " + gender + " " + dob + " " + email + " " + password;
//	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.setTitle("Add-Appointments");

		Text mainHeading = new Text("Add Appointment");
		mainHeading.setStyle("-fx-font-size: 30px");

		Label lbl_ptName = new Label("Patient Name");
		txt_ptName = new TextField();
		txt_ptName.setPromptText("Enter Patient Name");

//		Label lbl_docName = new Label("Doctor Name");
//		txt_docName = new TextField();
//		txt_docName.setPromptText("Enter Doctor Name");
		
		Label lbl_email = new Label("Email");
        cmb_email = new ComboBox<>();
        try {
        	cmb_email.getItems().addAll(Database.getColDataFromDb("user", "email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cmb_email.setPromptText("Select Email");

//		Label lbl_gender = new Label("Gender");
//		ToggleGroup rb_group = new ToggleGroup();
//		rb_female = new RadioButton("Female");
//		rb_male = new RadioButton("Male");
//		rb_female.setToggleGroup(rb_group);
//		rb_male.setToggleGroup(rb_group);

//		Label lbl_dob = new Label("Date Of Birth");

//		cmb_date = new ComboBox<>();
//		cmb_date.setPromptText("Date");
//		for (int i = 1; i <= 31; i++) {
//			cmb_date.getItems().add(i);
//		}

//		cmb_month = new ComboBox<>();
//		cmb_month.setPromptText("Month");
//		cmb_month.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August",
//				"September", "October", "November", "December");

//		cmb_year = new ComboBox<>();
//		cmb_year.setPromptText("Year");
//		for (int i = 1990; i <= 2023; i++) {
//			cmb_year.getItems().add(Integer.toString(i));
//		}

		Label lbl_consultant = new Label("Consultant");
        cmb_consultant = new ComboBox<>();
        try {
        	cmb_consultant.getItems().addAll(Database.getColDataFromDb("specializations", "specializationNames"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        cmb_consultant.setPromptText("Select Consultant");
        
        Label lbl_docName = new Label("Doctor Name");
        cmb_docName = new ComboBox<>();
        try {
        	cmb_docName.getItems().addAll(Database.getColDataFromDb("doctor", "first_name, last_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        cmb_docName.setPromptText("Select Doctor");
		
//		Label lbl_date = new Label("Date");
//
//		cmb_date = new ComboBox<>();
//		cmb_date.setPromptText("Date");
//		for (int i = 1; i <= 31; i++) {
//			cmb_date.getItems().add(i);
//		}
//
//		cmb_month = new ComboBox<>();
//		cmb_month.setPromptText("Month");
//		cmb_month.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August",
//				"September", "October", "November", "December");
//
//		cmb_year = new ComboBox<>();
//		cmb_year.setPromptText("Year");
//		for (int i = 1990; i <= 2023; i++) {
//			cmb_year.getItems().add(Integer.toString(i));
//		}
//        

		Label lbl_disease = new Label("Disease");
		txt_disease = new PasswordField();
		txt_disease.setPromptText("Enter Disease");


		Button btn_signup = new Button();
		btn_signup.setText("ADD");
		btn_signup.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
//					if (validateFields()) {
//						Database.insertIntoDb(getDoctorDetails(), "doctor");
						Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
						successAlert.setContentText("Appointment added successfully!");
						successAlert.showAndWait();
						
						txt_ptName.clear();
//		                txt_docName.clear();
		                cmb_email.setValue(null);
		                cmb_consultant.setValue(null);
//		                rb_male.setSelected(false);
//		                rb_female.setSelected(false);
//		                cmb_date.setValue(null);
//		                cmb_month.setValue(null);
//		                cmb_year.setValue(null);
//		                cmb_date.clear();
		                txt_disease.clear();
//		                cmb_consultant.setValue(null);

//					} else {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
						errorAlert.setContentText("Please fill out all the fields.");
						errorAlert.showAndWait();
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//					Alert errorAlert = new Alert(Alert.AlertType.ERROR);
//					errorAlert.setContentText(Database.getErrorMessage(e));
//					errorAlert.showAndWait();
				} catch (Exception e) {
					e.printStackTrace();
					Alert errorAlert = new Alert(Alert.AlertType.ERROR);
					errorAlert.setContentText("Error occurred while adding the doctor. Please try again.");
					errorAlert.showAndWait();
				}
			}

			// Validate
//			private boolean validateFields() {
//				return !txt_fName.getText().isEmpty() && !txt_lName.getText().isEmpty()
//						&& (rb_male.isSelected() || rb_female.isSelected()) && cmb_date.getValue() != null
//						&& cmb_month.getValue() != null && cmb_year.getValue() != null && !txt_email.getText().isEmpty()
//						&& !pass.getText().isEmpty() && cmb_specialization.getValue() != null;
//			}
		});

//		HBox gender = new HBox(20, rb_female, rb_male);
//		gender.setAlignment(Pos.CENTER);
//		HBox date = new HBox(20, cmb_date, cmb_month, cmb_year);
//		date.setAlignment(Pos.CENTER);

//		VBox layout = new VBox(20, mainHeading, lbl_firstName, txt_fName, lbl_lastName, txt_lName, lbl_gender, gender,
//				lbl_dob, date, lbl_email, txt_email, lbl_password, pass, lbl_specialization, cmb_specialization,
//				btn_signup);
		VBox layout = new VBox(20, mainHeading, lbl_ptName, txt_ptName, lbl_email, cmb_email, lbl_consultant, cmb_consultant, lbl_docName, cmb_docName, lbl_disease, txt_disease,  
				btn_signup);
		
		txt_ptName.setMaxWidth(200);
		txt_disease.setMaxWidth(200);
		layout.setAlignment(Pos.CENTER);

		btn_signup.setPadding(new Insets(5, 40, 5, 40));
		btn_signup.setStyle("-fx-font-size: 30px;-fx-background-color: #D3D3D3;");
		DropShadow shade2 = new DropShadow();
		btn_signup.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				btn_signup.setEffect(shade2);
			}
		});
		btn_signup.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				btn_signup.setEffect(null);
			}
		});
		btn_signup.setCursor(Cursor.HAND);

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
				AdminDashboard adminDashboard = new AdminDashboard();
				try {
					adminDashboard.start(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		layout.setAlignment(Pos.CENTER);
		VBox v = new VBox(10, goBack, layout);
		v.setMargin(layout, new Insets(150, 0, 0, 0));
		v.setStyle("-fx-background-color: #2B7490");

		signUpScene = new Scene(v, 1800, 980);
		stage.setResizable(false);
		stage.setScene(signUpScene);
		stage.show();

	}
}
