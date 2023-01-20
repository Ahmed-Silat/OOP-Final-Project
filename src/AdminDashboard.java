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

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;

		Text mainHeading = new Text();
		mainHeading.setText("WELCOME TO ADMIN PANEL\n");
		mainHeading.setFont(Font.font("Helvetica", FontWeight.BOLD, 60));
		mainHeading.setFill(Color.WHITE);

		// Rectangle box 1
//				Rectangle addDoctor = new Rectangle();
//				addDoctor.setWidth(250);
//				addDoctor.setHeight(150);
//				addDoctor.setFill(Color.web("#006A89"));
//				addDoctor.setStrokeWidth(5);
//				addDoctor.setStroke(Color.web("#73D2DD"));
//				addDoctor.setArcHeight(20);
//				addDoctor.setArcWidth(20);

		Button addDoctorBtn = new Button("ADD DOCTOR");
		addDoctorBtn.setCursor(Cursor.HAND);
		addDoctorBtn.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 30));
		addDoctorBtn.setTextFill(Color.WHITE);
		addDoctorBtn.setPadding(new Insets(58, 60, 58, 60));
		addDoctorBtn.setStyle("-fx-background-color: #007AA2;-fx-background-radius: 20px;");
		addDoctorBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				//Doctor firstDoctor = new Doctor();
//						try {
//							firstDoctor.start(stage);
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
			}
		});
//		Image addDoctorPic = new Image("images/general-01.png");
//		ImageView DoctorImage = new ImageView(addDoctorPic);
//		DoctorImage.setFitHeight(50);
//		DoctorImage.setFitWidth(60);
		// text box 1
		Text addDoctorText = new Text("ADD DOCTOR");
		StackPane box1 = new StackPane();
		VBox vertical1 = new VBox(10,  addDoctorText);
		vertical1.setAlignment(Pos.CENTER);
		box1.getChildren().addAll(vertical1, addDoctorBtn);
		addDoctorText.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		addDoctorText.setTextAlignment(TextAlignment.JUSTIFY);
		addDoctorText.setFill(Color.WHITE);
		// Creating a Shadow
		DropShadow shadow1 = new DropShadow();
		shadow1.setOffsetX(5);
		shadow1.setOffsetY(5);
		shadow1.setColor(Color.rgb(20, 20, 20, 0.5));
		addDoctorText.setEffect(shadow1);
		addDoctorText.setEffect(shadow1);
		// Creating a DropShadow when cursor touch the box
		DropShadow shade1 = new DropShadow();
		box1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				box1.setEffect(shade1);
			}
		});
		box1.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				box1.setEffect(null);
			}
		});
		// Create a hand cursor on object
		addDoctorBtn.setCursor(Cursor.HAND);

		Button deleteDrBtn = new Button("DELETE DOCTOR");
		deleteDrBtn.setCursor(Cursor.HAND);
		deleteDrBtn.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 30));
		deleteDrBtn.setTextFill(Color.WHITE);
		deleteDrBtn.setPadding(new Insets(58, 47, 58, 47));
		deleteDrBtn.setStyle("-fx-background-color: #009DCF;-fx-background-radius: 20px;");
		deleteDrBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				//Doctor secondDoctor = new Doctor();
//						try {
//							firstDoctor.start(stage);
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
			}
		});
//		Image deleteDoctorPic = new Image("images/general-01.png");
//		ImageView DoctorImage = new ImageView(deleteDoctorPic);
//		DoctorImage.setFitHeight(50);
//		DoctorImage.setFitWidth(60);
		// text box 1
		Text deleteDrText = new Text("DELETE DOCTOR");
		StackPane box2 = new StackPane();
		VBox vertical2 = new VBox(10,  deleteDrText);
		vertical2.setAlignment(Pos.CENTER);
		box2.getChildren().addAll(vertical2, deleteDrBtn);
		deleteDrText.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		deleteDrText.setTextAlignment(TextAlignment.JUSTIFY);
		deleteDrText.setFill(Color.WHITE);
		// Creating a Shadow
		DropShadow shadow2 = new DropShadow();
		shadow2.setOffsetX(5);
		shadow2.setOffsetY(5);
		shadow2.setColor(Color.rgb(20, 20, 20, 0.5));
		deleteDrText.setEffect(shadow2);
		deleteDrText.setEffect(shadow2);
		// Creating a DropShadow when cursor touch the box
		DropShadow shade2 = new DropShadow();
		box2.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				box2.setEffect(shade2);
			}
		});
		box2.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				box2.setEffect(null);
			}
		});
		// Create a hand cursor on object
		deleteDrBtn.setCursor(Cursor.HAND);
		
		//add patient Button
		Button addPatientBtn = new Button("ADD PATIENT");
		addPatientBtn.setCursor(Cursor.HAND);
		addPatientBtn.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 30));
		addPatientBtn.setTextFill(Color.WHITE);
		addPatientBtn.setPadding(new Insets(58, 63, 58, 63));
		addPatientBtn.setStyle("-fx-background-color: #006A89;-fx-background-radius: 20px;");
		addPatientBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Patient firstPatient = new Patient();
//						try {
//							firstDoctor.start(stage);
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
			}
		});
//		Image deleteDoctorPic = new Image("images/general-01.png");
//		ImageView DoctorImage = new ImageView(deleteDoctorPic);
//		DoctorImage.setFitHeight(50);
//		DoctorImage.setFitWidth(60);
		// text box 1
		Text addPatientText = new Text("ADD PATIENT");
		StackPane box3 = new StackPane();
		VBox vertical3 = new VBox(10,  addPatientText);
		vertical3.setAlignment(Pos.CENTER);
		box3.getChildren().addAll(vertical3, addPatientBtn);
		addPatientText.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		addPatientText.setTextAlignment(TextAlignment.JUSTIFY);
		addPatientText.setFill(Color.WHITE);
		// Creating a Shadow
		DropShadow shadow3 = new DropShadow();
		shadow3.setOffsetX(5);
		shadow3.setOffsetY(5);
		shadow3.setColor(Color.rgb(20, 20, 20, 0.5));
		addPatientText.setEffect(shadow3);
		addPatientText.setEffect(shadow3);
		// Creating a DropShadow when cursor touch the box
		DropShadow shade3 = new DropShadow();
		box3.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				box3.setEffect(shade3);
			}
		});
		box3.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				box3.setEffect(null);
			}
		});
		// Create a hand cursor on object
		addPatientBtn.setCursor(Cursor.HAND);
		
		//delete patient button
		Button deletePatientBtn = new Button("DELETE PATIENT");
		deletePatientBtn.setCursor(Cursor.HAND);
		deletePatientBtn.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 30));
		deletePatientBtn.setTextFill(Color.WHITE);
		deletePatientBtn.setPadding(new Insets(58, 50, 58, 50));
		deletePatientBtn.setStyle("-fx-background-color: #3E77B6;-fx-background-radius: 20px;");
		deletePatientBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				//Patient firstPatient = new Patient();
//						try {
//							firstDoctor.start(stage);
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
			}
		});
//		Image deleteDoctorPic = new Image("images/general-01.png");
//		ImageView DoctorImage = new ImageView(deleteDoctorPic);
//		DoctorImage.setFitHeight(50);
//		DoctorImage.setFitWidth(60);
		// text box 1
		Text deletePatientText = new Text("DELETE PATIENT");
		StackPane box4 = new StackPane();
		VBox vertical4 = new VBox(10,  deletePatientText);
		vertical4.setAlignment(Pos.CENTER);
		box4.getChildren().addAll(vertical4, deletePatientBtn);
		deletePatientText.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		deletePatientText.setTextAlignment(TextAlignment.JUSTIFY);
		deletePatientText.setFill(Color.WHITE);
		// Creating a Shadow
		DropShadow shadow4 = new DropShadow();
		shadow4.setOffsetX(5);
		shadow4.setOffsetY(5);
		shadow4.setColor(Color.rgb(20, 20, 20, 0.5));
		deletePatientText.setEffect(shadow4);
		deletePatientText.setEffect(shadow4);
		// Creating a DropShadow when cursor touch the box
		DropShadow shade4 = new DropShadow();
		box4.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				box4.setEffect(shade4);
			}
		});
		box4.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				box4.setEffect(null);
			}
		});
		// Create a hand cursor on object
		deletePatientBtn.setCursor(Cursor.HAND);
		
		//Logout button
		Button logoutBtn = new Button("LOGOUT");
		logoutBtn.setCursor(Cursor.HAND);
		logoutBtn.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 10));
		logoutBtn.setTextFill(Color.WHITE);
		logoutBtn.setPadding(new Insets(10, 32, 10, 32));
		logoutBtn.setStyle("-fx-background-color: #3FABC4;-fx-background-radius: 20px;");
		logoutBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				//Patient firstPatient = new Patient();
//						try {
//							firstDoctor.start(stage);
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
			}
		});
//		Image deleteDoctorPic = new Image("images/general-01.png");
//		ImageView DoctorImage = new ImageView(deleteDoctorPic);
//		DoctorImage.setFitHeight(50);
//		DoctorImage.setFitWidth(60);
		// text box 1
		Text logoutText = new Text("LOGOUT");
		StackPane box5 = new StackPane();
		VBox vertical5 = new VBox(10,  logoutText);
		vertical5.setAlignment(Pos.CENTER);
		box5.getChildren().addAll(vertical5, logoutBtn);
		logoutText.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 10));
		logoutText.setTextAlignment(TextAlignment.JUSTIFY);
		logoutText.setFill(Color.WHITE);
		// Creating a Shadow
		DropShadow shadow5 = new DropShadow();
		shadow5.setOffsetX(5);
		shadow5.setOffsetY(5);
		shadow5.setColor(Color.rgb(20, 20, 20, 0.5));
		logoutText.setEffect(shadow5);
		logoutText.setEffect(shadow5);
		// Creating a DropShadow when cursor touch the box
		DropShadow shade5 = new DropShadow();
		box5.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				box5.setEffect(shade5);
			}
		});
		box5.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				box5.setEffect(null);
			}
		});
		// Create a hand cursor on object
		logoutBtn.setCursor(Cursor.HAND);

		HBox h1 = new HBox(10, box1, box2);
		h1.setAlignment(Pos.CENTER);
		HBox h2= new HBox(10,box3, box4);
		h2.setAlignment(Pos.CENTER);
		HBox h3 = new HBox(10,box5);
		h3.setAlignment(Pos.CENTER);
		

		VBox layout = new VBox(10, mainHeading, h1,h2,h3);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 1000, 1000);
		layout.setStyle("-fx-background-color:#5A8493");

		primaryStage.setTitle("DASHBOARD");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
