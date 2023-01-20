import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
//import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	Scene scene;
	Stage login_stage;
	TextField txt_email;
	PasswordField pass;

	public void goToDashboard(String email, String password) {
		Authentication auth = new Authentication();
		if (auth.signIn(email, password) == true) {
			UserDashboard userDashboard = new UserDashboard();
			try {
				userDashboard.start(login_stage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		login_stage = primaryStage;

		Text mainHeading = new Text("Login");
		mainHeading.setStyle("-fx-font-size: 30px");

		Image loginImage = new Image("images/login.png", 60, 60, false, false);
		ImageView loginImageView = new ImageView(loginImage);

		ComboBox cmb_users = new ComboBox<String>();
		cmb_users.setPromptText("Select User");
		cmb_users.getItems().addAll("Admin", "Customer");

		Label lbl_email = new Label("Email");
		txt_email = new TextField();
		txt_email.setPromptText("Enter Email");

		Label lbl_password = new Label("Password");
		pass = new PasswordField();
		pass.setPromptText("Enter Password");
		CheckBox chk = new CheckBox("Show password");
		TextField passwordText = new TextField();
		passwordText.setPromptText("Enter Password");
		chk.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (chk.isSelected()) {
					passwordText.setText(pass.getText());
					passwordText.setVisible(true);
					pass.setVisible(false);
					return;
				} else {
					pass.setText(passwordText.getText());
					pass.setVisible(true);
					passwordText.setVisible(false);
				}

			}
		});

		Button login_btn = new Button();
		login_btn.setText("Login");
		login_btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				goToDashboard(txt_email.getText(), pass.getText());
			}
		});

		Button signup_btn = new Button();
		signup_btn.setText("Signup");
		signup_btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				SignUpUI signup = new SignUpUI();
				try {
					signup.start(login_stage);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		VBox layout = new VBox(20, loginImageView, mainHeading, cmb_users, txt_email, passwordText, pass, chk,
				login_btn, signup_btn);

		cmb_users.setMaxWidth(200);
		txt_email.setMaxWidth(200);
		pass.setMaxWidth(200);
		passwordText.setMaxWidth(200);
		layout.setMargin(pass, new Insets(-51, 0, 0, 0));
		layout.setMargin(chk, new Insets(-18, 0, 0, -65));
		login_btn.setPadding(new Insets(5, 50, 5, 50));
		login_btn.setStyle("-fx-font-size: 30px;-fx-background-color: #ADD8E6;");
		DropShadow shade1 = new DropShadow();
		login_btn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				login_btn.setEffect(shade1);
			}
		});
		login_btn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				login_btn.setEffect(null);
			}
		});
		login_btn.setCursor(Cursor.HAND);

		signup_btn.setPadding(new Insets(5, 40, 5, 40));
		signup_btn.setStyle("-fx-font-size: 30px;-fx-background-color: #FFE5B4;");
		DropShadow shade2 = new DropShadow();
		signup_btn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				signup_btn.setEffect(shade2);
			}
		});
		signup_btn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				signup_btn.setEffect(null);
			}
		});
		signup_btn.setCursor(Cursor.HAND);

		layout.setAlignment(Pos.CENTER);

		layout.setStyle("-fx-background-color: #90B1D8,#3E7786");

		scene = new Scene(layout, 1000, 1000);
//		scene.setFill(new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, new Stop(0, Color.web("#90B1D8")),
//				new Stop(1, Color.web("#3E7786"))));

		login_stage.setTitle("Login-page");
		login_stage.setScene(scene);
		login_stage.show();
	}
}
