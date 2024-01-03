import java.io.FileInputStream;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DeletePatientUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	Scene scene;
	Stage stage;
	TextField txt_email;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;

		Text mainHeading = new Text("DELETE PATIENT");
		mainHeading.setStyle("-fx-font-size: 30px");
		mainHeading.setFill(Color.WHITESMOKE);

		txt_email = new TextField();
		txt_email.setPromptText("Enter Email");

		Button deleteBtn = new Button();
		deleteBtn.setText("Delete");
		deleteBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					Filing filing = new Filing();
					DeletePatient deletePatient = new DeletePatient();
					ArrayList<String> patients = deletePatient.deletePatientByEmail(filing.readData("signup.txt"),
							txt_email.getText());
					String dataToWrite = deletePatient.arrayListToString(patients);
					txt_email.clear();
					filing.clearAndWriteData(dataToWrite, "signup.txt");
					Alert removeUser = new Alert(Alert.AlertType.INFORMATION);
					removeUser.setContentText("Patient Removed Successfully");
					removeUser.show();
//					filing.readData("signup.txt");
				} catch (Exception e) {
					Alert loginError = new Alert(Alert.AlertType.ERROR);
					loginError.setContentText("Please fill out all the fields");
					loginError.show();
				}
			}
		});

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

		VBox layout = new VBox(20, mainHeading, txt_email, deleteBtn);

		VBox mainVbox = new VBox(10, goBack, layout);

		txt_email.setMaxWidth(200);
		deleteBtn.setPadding(new Insets(5, 50, 5, 50));
		deleteBtn.setStyle("-fx-font-size: 30px;-fx-background-color: #7d1211;");
		deleteBtn.setTextFill(Color.WHITE);
		DropShadow shade1 = new DropShadow();
		deleteBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				deleteBtn.setEffect(shade1);
			}
		});
		deleteBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				deleteBtn.setEffect(null);
			}
		});
		deleteBtn.setCursor(Cursor.HAND);

		layout.setAlignment(Pos.CENTER);
		mainVbox.setMargin(layout, new Insets(300, 0, 0, 0));

		mainVbox.setStyle("-fx-background-color: #2B7490");

		scene = new Scene(mainVbox, 1800, 980);
		stage.setTitle("Delete Patient");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
}
