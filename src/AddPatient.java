import java.io.FileInputStream;

import org.w3c.dom.UserDataHandler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class AddPatient extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	Scene signUpScene;
	Stage stage;
	LoginUI login = new LoginUI();
	User userData;
	TextField txt_fName, txt_lName, txt_email;
	RadioButton rb_male, rb_female;
	ComboBox cmb_date, cmb_month, cmb_year;
	PasswordField pass, rePass;

//	public void dataWriting() {
//		UserAuthentication auth = new UserAuthentication();
//		if (auth.signUp(getUserDetails()) == true) {
////			UserDashboard userDashboard = new UserDashboard();
//			try {
////				userDashboard.start(stage);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else {
//			auth.signUp(getUserDetails());
//		}
//	}

	String month[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
			"November", "December" };

	public User getUserDetails() {
		userData.setFirstName(txt_fName.getText());
		userData.setLastName(txt_lName.getText());
		if (rb_male.isSelected()) {
			userData.setGender("Male");
		} else if (rb_female.isSelected()) {
			userData.setGender("Female");
		}
		userData.setDate(cmb_date.getValue().toString());
		userData.setMonth(cmb_month.getValue().toString());
		userData.setYear(cmb_year.getValue().toString());
		userData.setEmail(txt_email.getText());
		userData.setPassword(pass.getText());
		userData.setConfirmPassword(rePass.getText());
		return userData;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.setTitle("Add-Patient");
		userData = new User();

		Text mainHeading = new Text("ADD PATIENT");
		mainHeading.setStyle("-fx-font-size: 30px");

//		Image signupImage = new Image("images/signup.png", 100, 100, false, false);
//		ImageView signupImageView = new ImageView(signupImage);

		Label lbl_firstName = new Label("First Name");
		txt_fName = new TextField();
		txt_fName.setPromptText("Enter First Name");

		Label lbl_lastName = new Label("Last Name");
		txt_lName = new TextField();
		txt_lName.setPromptText("Enter Last Name");

		Label lbl_gender = new Label("Gender");
		ToggleGroup rb_group = new ToggleGroup();
		rb_female = new RadioButton("Female");
		rb_male = new RadioButton("Male");
		rb_female.setToggleGroup(rb_group);
		rb_male.setToggleGroup(rb_group);

		Label lbl_dob = new Label("Date Of Birth");
		cmb_date = new ComboBox<String>();
		cmb_date.setPromptText("Date");
		for (int i = 1; i <= 31; i++) {
			cmb_date.getItems().add(i);
		}

		cmb_month = new ComboBox<String>();
		cmb_month.setPromptText("Month");
		for (int i = 0; i < month.length; i++) {
			cmb_month.getItems().add(month[i]);
		}

		cmb_year = new ComboBox<String>();
		cmb_year.setPromptText("Year");
		for (int i = 1990; i <= 2023; i++) {
			cmb_year.getItems().add(i);
		}

		Label lbl_email = new Label("Email");
		txt_email = new TextField();
		txt_email.setPromptText("Enter Email");

		Label lbl_password = new Label("Password");
		pass = new PasswordField();
		pass.setPromptText("Enter Password");
		CheckBox chk1 = new CheckBox("Show password");
		TextField passwordText1 = new TextField();
		passwordText1.setPromptText("Enter Password");
		chk1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (chk1.isSelected()) {
					passwordText1.setText(pass.getText());
					passwordText1.setVisible(true);
					pass.setVisible(false);
					return;
				} else {
					pass.setText(passwordText1.getText());
					pass.setVisible(true);
					passwordText1.setVisible(false);
				}

			}
		});

		Label lbl_rePassword = new Label("Re-Enter Password");
		rePass = new PasswordField();
		rePass.setPromptText("Re-Enter Password");
		CheckBox chk2 = new CheckBox("Show password");
		TextField passwordText2 = new TextField();
		passwordText2.setPromptText("Re-Enter Password");
		chk2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (chk2.isSelected()) {
					passwordText2.setText(rePass.getText());
					passwordText2.setVisible(true);
					rePass.setVisible(false);
					return;
				} else {
					rePass.setText(passwordText2.getText());
					rePass.setVisible(true);
					passwordText2.setVisible(false);
				}

			}
		});

		Button btn_signup = new Button();
		btn_signup.setText("ADD");
		btn_signup.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					UserAuthentication auth = new UserAuthentication();
					auth.signUp(getUserDetails());
				} catch (Exception e) {
					Alert loginError = new Alert(Alert.AlertType.ERROR);
					loginError.setContentText("Please fill out all the fields");
					loginError.show();
				}
			}
		});

		HBox gender = new HBox(20, rb_female, rb_male);
		gender.setAlignment(Pos.CENTER);
		HBox date = new HBox(20, cmb_date, cmb_month, cmb_year);
		date.setAlignment(Pos.CENTER);

		VBox layout = new VBox(20, mainHeading, txt_fName, txt_lName, gender, date, txt_email, passwordText1, pass,
				chk1, passwordText2, rePass, chk2, btn_signup);
		txt_fName.setMaxWidth(200);
		txt_lName.setMaxWidth(200);
		txt_email.setMaxWidth(200);
		pass.setMaxWidth(200);
		passwordText1.setMaxWidth(200);
		layout.setMargin(pass, new Insets(-51, 0, 0, 0));
		layout.setMargin(chk1, new Insets(-18, 0, 0, -65));
		rePass.setMaxWidth(200);
		passwordText2.setMaxWidth(200);
		layout.setMargin(rePass, new Insets(-51, 0, 0, 0));
		layout.setMargin(chk2, new Insets(-18, 0, 0, -65));

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
					// TODO Auto-generated catch block
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
