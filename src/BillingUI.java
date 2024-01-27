
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
import javafx.scene.control.TextArea;
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

public class BillingUI extends Application {

	Scene signUpScene;
	Stage stage;
	TextField txt_ptName;
	ComboBox<String> cmb_email;
	TextField billing;
	TextField patientText;

	public String getAppointmentDetails() {
		String email = cmb_email.getValue();
		String fullName = txt_ptName.getText();

		String[] parts = fullName.split(" ");

		String formattedName = String.join("-", parts);

		String bill = billing.getText();

		String patient_id = patientText.getText();

		return email + " " + formattedName + " " + bill + " " + patient_id;
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.setTitle("Billing");

		Text mainHeading = new Text("GENERATE BILL");
		mainHeading.setStyle("-fx-font-size: 40px");
		mainHeading.setFill(Color.WHITE);

		Label lbl_email = new Label("Patient Email");
		lbl_email.setTextFill(Color.WHITE);
		cmb_email = new ComboBox<>();
		try {
			cmb_email.getItems().addAll(Database.getColDataFromDb("user", "email"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cmb_email.setPromptText("Select Email");

		Label lbl_ptName = new Label("Patient Name");
		lbl_ptName.setTextFill(Color.WHITE);
		txt_ptName = new TextField();
		txt_ptName.setPromptText("Patient Name");

		txt_ptName.setEditable(false);

		Label lbl_docName = new Label("Bill Amount");
		lbl_docName.setTextFill(Color.WHITE);
		billing = new TextField();
		billing.setPromptText("Amount");

		Label patient_id = new Label("Patient Id");
		patient_id.setTextFill(Color.WHITE);
		patientText = new TextField();
		patientText.setPromptText("Patient Id");

		cmb_email.setOnAction(event -> {
			String selectedEmail = cmb_email.getValue();
			if (selectedEmail != null) {
				try {
					String columns = "CONCAT(first_name, ' ', last_name)";
					List<String> names = Database.getConditioinalDataFromDb("user", columns, "email", selectedEmail);

					if (!names.isEmpty()) {
						String fullName = names.get(0);
						txt_ptName.setText(fullName);
					} else {
						txt_ptName.setText("");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		Button btn_signup = new Button("GENERATE BILL");

		btn_signup.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					if (validateFields()) {
						Database.insertIntoDb(getAppointmentDetails(), "billing");
						Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
						successAlert.setContentText("Bill Generated successfully!");
						successAlert.showAndWait();

						txt_ptName.clear();
						cmb_email.setValue(null);
						billing.clear();

					} else {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
						errorAlert.setContentText("Please fill out all the fields.");
						errorAlert.showAndWait();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					Alert errorAlert = new Alert(Alert.AlertType.ERROR);
					errorAlert.setContentText(Database.getErrorMessage(e));
					errorAlert.showAndWait();
				} catch (Exception e) {
					e.printStackTrace();
					Alert errorAlert = new Alert(Alert.AlertType.ERROR);
					errorAlert.setContentText("Error occurred while Generating the Bill. Please try again.");
					errorAlert.showAndWait();
				}
			}

//			 Validate
			private boolean validateFields() {
				return !txt_ptName.getText().isEmpty() && cmb_email.getValue() != null;
			}
		});
		VBox layout = new VBox(20, mainHeading, lbl_email, cmb_email, lbl_ptName, txt_ptName, lbl_docName, billing,
				patient_id, patientText, btn_signup);

		txt_ptName.setMaxWidth(200);
		billing.setMaxWidth(200);
		patientText.setMaxWidth(200);
		layout.setAlignment(Pos.CENTER);

		btn_signup.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		btn_signup.setTextFill(Color.WHITE);
		btn_signup.setStyle("-fx-background-color: black; -fx-background-radius: 20px;");
		btn_signup.setPadding(new Insets(0, 20, 0, 20));
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
		btn_signup.setFont(Font.font(20));
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
