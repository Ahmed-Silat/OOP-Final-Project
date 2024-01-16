import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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

public class Surgery extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	Stage stage;
	Scene scene;
	ComboBox<String> dr_names;
	TextArea txt_disease;

	public String getAppointmentDetails() throws SQLException {
		String disease = txt_disease.getText();

		String[] parts = disease.split(" ");

		String formattedDisease = String.join("-", parts);

		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = currentDate.format(formatter);
		String patientEmail = UserAuthentication.getUserEmail();
		int patientId = Database.getIdByCondition("user", "u_id", "email", UserAuthentication.getUserEmail());
		int doctorId = Database.getIdByCondition("doctor", "d_id", "name", dr_names.getValue());
		int specializationId = Database.getIdByCondition("specializations", "s_id", "specializationNames", "Surgeon");

		return patientId + " " + patientEmail + " " + doctorId + " " + specializationId + " " + formattedDate + " "
				+ formattedDisease;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.setTitle("Book An Appointment");

		Text mainHeading = new Text();
		mainHeading.setText("SURGEON\n");
		mainHeading.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
		mainHeading.setFill(Color.WHITESMOKE);

		Label lbl_doctor = new Label("Doctor Name");
		lbl_doctor.setTextFill(Color.WHITE);
		lbl_doctor.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
		dr_names = new ComboBox<>();
		dr_names.setPromptText("Select Doctor");

		try {
			ArrayList<String> surgeonNames = Database.getDataFromDb("doctor", "name", "specializations", "s_id",
					"specializationNames", "Surgeon", "INNER JOIN");

			dr_names.getItems().addAll(surgeonNames);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Label lbl_disease = new Label("Disease History");
		lbl_disease.setTextFill(Color.WHITE);
		lbl_disease.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
		txt_disease = new TextArea();
		txt_disease.setPromptText("Enter Your Disease");

		HBox h6 = new HBox(45, lbl_doctor, dr_names);

		VBox points = new VBox(40, h6);
		VBox disease = new VBox(30, lbl_disease, txt_disease);

		HBox h = new HBox(25, points, disease);
		h.setMargin(disease, new Insets(0, 0, 0, 150));
		h.setAlignment(Pos.CENTER);

		HBox heading = new HBox(50, mainHeading);
		heading.setAlignment(Pos.CENTER);

		// save Button
		Button saveBtn = new Button("Book An Appointment");
		saveBtn.setCursor(Cursor.HAND);
		HBox save = new HBox(saveBtn);
		saveBtn.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		saveBtn.setTextFill(Color.WHITE);
		saveBtn.setStyle("-fx-background-color: black;-fx-background-radius: 20px;");
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
		cancelBtn.setStyle("-fx-background-color: black;-fx-background-radius: 20px;");
		cancelBtn.setPadding(new Insets(10, 30, 10, 30));

		cancelBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				UserDashboard userDashboard = new UserDashboard();
				try {
					userDashboard.start(stage);
				} catch (Exception e) {
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
		backBtn.setStyle("-fx-background-color: black; -fx-background-radius: 20px;");
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

					info += "Gender: " + gender + "\n";

					info += "Doctor: " + dr_names.getSelectionModel().getSelectedItem() + "\n";

					info += "Disease History: " + txt_disease.getText();

					if (txt_disease.getText().equals("")) {
						Alert nullError = new Alert(Alert.AlertType.ERROR);
						nullError.setContentText("Fill out the Disease History Field");
						nullError.show();
					} else {
						Database.insertIntoDb(getAppointmentDetails(), "appointments");
						Alert a = new Alert(AlertType.INFORMATION);
						a.setContentText("Your appointment has been booked successfully!\n\n" + info);
						a.show();
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