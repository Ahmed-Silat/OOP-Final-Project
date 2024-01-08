
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.Cursor;

public class UserDashboard extends Application {

	Background background;

	public static void main(String[] args) {
		launch(args);
	}

	Stage stage;
	Rectangle pharmacyBox;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;

		Text mainHeading = new Text();
		mainHeading.setText("WELCOME TO HOSPITAL MANAGEMENT SYSTEM\n");
		mainHeading.setFont(Font.font("Helvetica", FontWeight.BOLD, 60));
		mainHeading.setFill(Color.WHITE);

		// Rectangle box 1
		pharmacyBox = new Rectangle();
		pharmacyBox.setWidth(250);
		pharmacyBox.setHeight(150);
		pharmacyBox.setFill(Color.web("#006A89"));
		pharmacyBox.setStrokeWidth(5);
		pharmacyBox.setStroke(Color.web("#73D2DD"));
		pharmacyBox.setArcHeight(20);
		pharmacyBox.setArcWidth(20);

		Button pharmacyBtn = new Button("");
		pharmacyBtn.setPadding(new Insets(130, 250, 0, 0));
		pharmacyBtn.setStyle("-fx-background-color: transparent;");
		pharmacyBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Pharmacy pharmacy = new Pharmacy();
				try {
					pharmacy.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Image pharmacyPic = new Image("images/pharmacy2-01.png");
		ImageView imagePic1 = new ImageView(pharmacyPic);
		imagePic1.setFitHeight(50);
		imagePic1.setFitWidth(60);
		// text box 1
		Text pharmacyText = new Text("PHARMACY");
		StackPane box1 = new StackPane();
		VBox vertical1 = new VBox(10, imagePic1, pharmacyText);
		vertical1.setAlignment(Pos.CENTER);
		box1.getChildren().addAll(pharmacyBox, vertical1, pharmacyBtn);
		pharmacyText.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		pharmacyText.setTextAlignment(TextAlignment.JUSTIFY);
		pharmacyText.setFill(Color.WHITE);
		// Creating a Shadow
		DropShadow shadow1 = new DropShadow();
		shadow1.setOffsetX(5);
		shadow1.setOffsetY(5);
		shadow1.setColor(Color.rgb(20, 20, 20, 0.5));
		pharmacyText.setEffect(shadow1);
		imagePic1.setEffect(shadow1);
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
		pharmacyBtn.setCursor(Cursor.HAND);

		// Rectangle box 2
		Rectangle neurologyBox = new Rectangle();
		neurologyBox.setWidth(250);
		neurologyBox.setHeight(150);
		neurologyBox.setFill(Color.web("#007AA2"));
		neurologyBox.setStrokeWidth(5);
		neurologyBox.setStroke(Color.web("#73D2DD"));
		neurologyBox.setArcHeight(20);
		neurologyBox.setArcWidth(20);

		Button neurologyBtn = new Button("");
		neurologyBtn.setPadding(new Insets(130, 250, 0, 0));
		neurologyBtn.setStyle("-fx-background-color: transparent;");
		neurologyBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Neurologist neurology = new Neurologist();
				try {
					neurology.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		// Image box 2
		Image neurologyPic = new Image("images/neurology1-01.png");
		ImageView imagePic2 = new ImageView(neurologyPic);
		imagePic2.setFitHeight(50);
		imagePic2.setFitWidth(50);
		// text box 2
		Text neurologyText = new Text("NEUROLOGY");
		StackPane box2 = new StackPane();
		VBox vertical2 = new VBox(10, imagePic2, neurologyText);
		vertical2.setAlignment(Pos.CENTER);
		box2.getChildren().addAll(neurologyBox, vertical2, neurologyBtn);
		neurologyText.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		neurologyText.setTextAlignment(TextAlignment.JUSTIFY);
		neurologyText.setFill(Color.WHITE);
		// Creating a shadow
		DropShadow shadow2 = new DropShadow();
		shadow2.setOffsetX(5);
		shadow2.setOffsetY(5);
		shadow2.setColor(Color.rgb(20, 20, 20, 0.5));
		neurologyText.setEffect(shadow2);
		imagePic2.setEffect(shadow2);
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
		neurologyBtn.setCursor(Cursor.HAND);

		// Rectangle box 3
		Rectangle cardiologyBox = new Rectangle();
		cardiologyBox.setWidth(250);
		cardiologyBox.setHeight(150);
		cardiologyBox.setFill(Color.web("#009DCF"));
		cardiologyBox.setStrokeWidth(5);
		cardiologyBox.setStroke(Color.web("#73D2DD"));
		cardiologyBox.setArcHeight(20);
		cardiologyBox.setArcWidth(20);

		Button cardiologyBtn = new Button("");
		cardiologyBtn.setPadding(new Insets(130, 250, 0, 0));
		cardiologyBtn.setStyle("-fx-background-color: transparent;");
		cardiologyBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Cardiologist cardiology = new Cardiologist();
				try {
					cardiology.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		// Image box 3
		Image cardiologyPic = new Image("images/cardiology1-01.png");
		ImageView imagePic3 = new ImageView(cardiologyPic);
		imagePic3.setFitWidth(65);
		imagePic3.setFitHeight(50);
		// text box 3
		Text cardiologyText = new Text("CARDIOLOGY");
		StackPane box3 = new StackPane();
		VBox vertical3 = new VBox(10, imagePic3, cardiologyText);
		vertical3.setAlignment(Pos.CENTER);
		box3.getChildren().addAll(cardiologyBox, vertical3, cardiologyBtn);
		cardiologyText.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		cardiologyText.setTextAlignment(TextAlignment.JUSTIFY);
		cardiologyText.setFill(Color.WHITE);
		// Creating a shadow
		DropShadow shadow3 = new DropShadow();
		shadow3.setOffsetX(5);
		shadow3.setOffsetY(5);
		shadow3.setColor(Color.rgb(20, 20, 20, 0.5));
		cardiologyText.setEffect(shadow3);
		imagePic3.setEffect(shadow2);
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
		cardiologyBtn.setCursor(Cursor.HAND);

		// Rectangle box 4
		Rectangle surgeryBox = new Rectangle();
		surgeryBox.setWidth(250);
		surgeryBox.setHeight(150);
		surgeryBox.setFill(Color.web("#3E77B6"));
		surgeryBox.setStrokeWidth(5);
		surgeryBox.setStroke(Color.web("#73D2DD"));
		surgeryBox.setArcHeight(20);
		surgeryBox.setArcWidth(20);

		Button surgeryBtn = new Button("");
		surgeryBtn.setPadding(new Insets(130, 250, 0, 0));
		surgeryBtn.setStyle("-fx-background-color: transparent;");
		surgeryBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Surgery surgery = new Surgery();
				try {
					surgery.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		// Image box 4
		Image surgeryPic = new Image("images/surgon-01.png");
		ImageView imagePic4 = new ImageView(surgeryPic);
		imagePic4.setFitWidth(55);
		imagePic4.setFitHeight(50);
		// Text box 4
		Text text4 = new Text("SURGERY");
		StackPane box4 = new StackPane();
		VBox vertical4 = new VBox(10, imagePic4, text4);
		vertical4.setAlignment(Pos.CENTER);
		box4.getChildren().addAll(surgeryBox, vertical4, surgeryBtn);
		text4.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		text4.setTextAlignment(TextAlignment.JUSTIFY);
		text4.setFill(Color.WHITE);
		// Creating a shadow
		DropShadow shadow4 = new DropShadow();
		shadow4.setOffsetX(5);
		shadow4.setOffsetY(5);
		shadow4.setColor(Color.rgb(20, 20, 20, 0.5));
		text4.setEffect(shadow4);
		imagePic4.setEffect(shadow2);
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
		surgeryBtn.setCursor(Cursor.HAND);

		// Rectangle box 5
		Rectangle physiotherapyBox = new Rectangle();
		physiotherapyBox.setWidth(250);
		physiotherapyBox.setHeight(150);
		physiotherapyBox.setFill(Color.web("#3FABC4"));
		physiotherapyBox.setStrokeWidth(5);
		physiotherapyBox.setStroke(Color.web("#73D2DD"));
		physiotherapyBox.setArcHeight(20);
		physiotherapyBox.setArcWidth(20);

		Button physiotherapyBtn = new Button("");
		physiotherapyBtn.setPadding(new Insets(130, 250, 0, 0));
		physiotherapyBtn.setStyle("-fx-background-color: transparent;");
		physiotherapyBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Physiotherapist physiotherapist = new Physiotherapist();
				try {
					physiotherapist.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		// Image box 5
		Image physiotherapyPic = new Image("images/physiotherapy1-01.png");
		ImageView imagePic5 = new ImageView(physiotherapyPic);
		imagePic5.setFitWidth(50);
		imagePic5.setFitHeight(50);
		// Text box 5
		Text text5 = new Text("PHYSIOTHERAPY");
		StackPane box5 = new StackPane();
		VBox vertical5 = new VBox(10, imagePic5, text5);
		vertical5.setAlignment(Pos.CENTER);
		box5.getChildren().addAll(physiotherapyBox, vertical5, physiotherapyBtn);
		text5.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		text5.setTextAlignment(TextAlignment.JUSTIFY);
		text5.setFill(Color.WHITE);
		// Creating a shadow
		DropShadow shadow5 = new DropShadow();
		shadow5.setOffsetX(5);
		shadow5.setOffsetY(5);
		shadow5.setColor(Color.rgb(20, 20, 20, 0.5));
		text5.setEffect(shadow5);
		imagePic5.setEffect(shadow2);
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
		physiotherapyBtn.setCursor(Cursor.HAND);

		// Rectangle box 6
		Rectangle generalPhysicianBox = new Rectangle();
		generalPhysicianBox.setWidth(250);
		generalPhysicianBox.setHeight(150);
		generalPhysicianBox.setFill(Color.web("#289ABA"));
		generalPhysicianBox.setStrokeWidth(5);
		generalPhysicianBox.setStroke(Color.web("#73D2DD"));
		generalPhysicianBox.setArcHeight(20);
		generalPhysicianBox.setArcWidth(20);

		Button generalPhysicianBtn = new Button("");
		generalPhysicianBtn.setPadding(new Insets(130, 250, 0, 0));
		generalPhysicianBtn.setStyle("-fx-background-color: transparent;");
		generalPhysicianBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				GeneralPhysician generalPhysician = new GeneralPhysician();
				try {
					generalPhysician.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		// Image box 5
		Image generalPhysicianPic = new Image("images/general-01.png");
		ImageView imagePic6 = new ImageView(generalPhysicianPic);
		imagePic6.setFitWidth(55);
		imagePic6.setFitHeight(50);
		// Text box 5
		Text text6 = new Text("GENERAL PHYSICIAN");
		StackPane box6 = new StackPane();
		VBox vertical6 = new VBox(10, imagePic6, text6);
		vertical6.setAlignment(Pos.CENTER);
		box6.getChildren().addAll(generalPhysicianBox, vertical6, generalPhysicianBtn);
		text6.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		text6.setTextAlignment(TextAlignment.JUSTIFY);
		text6.setFill(Color.WHITE);
		// Creating a shadow
		DropShadow shadow6 = new DropShadow();
		shadow6.setOffsetX(5);
		shadow6.setOffsetY(5);
		shadow6.setColor(Color.rgb(20, 20, 20, 0.5));
		text6.setEffect(shadow6);
		imagePic6.setEffect(shadow2);
		// Creating a DropShadow when cursor touch the box
		DropShadow shade6 = new DropShadow();
		box6.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				box6.setEffect(shade6);
			}
		});
		box6.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				box6.setEffect(null);
			}
		});
		// Create a hand cursor on object
		generalPhysicianBtn.setCursor(Cursor.HAND);

		// Rectangle box 6
		Rectangle appoinmentBox = new Rectangle();
		appoinmentBox.setWidth(250);
		appoinmentBox.setHeight(150);
		appoinmentBox.setFill(Color.web("#3D81CB"));
		appoinmentBox.setStrokeWidth(5);
		appoinmentBox.setStroke(Color.web("#73D2DD"));
		appoinmentBox.setArcHeight(20);
		appoinmentBox.setArcWidth(20);
		Button appointmentBtn = new Button("");
		appointmentBtn.setPadding(new Insets(130, 250, 0, 0));
		appointmentBtn.setStyle("-fx-background-color: transparent;");
		appointmentBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Appointments appointments = new Appointments();
				try {
					appointments.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		// Image box 5
		Image appionmentPic = new Image("images/Appoinment-01.png");
		ImageView imagePic7 = new ImageView(appionmentPic);
		imagePic7.setFitWidth(90);
		imagePic7.setFitHeight(50);
		// Text box 5
		Text text7 = new Text("APPOINTMENT");
		StackPane box7 = new StackPane();
		VBox vertical7 = new VBox(10, imagePic7, text7);
		vertical7.setAlignment(Pos.CENTER);
		box7.getChildren().addAll(appoinmentBox, vertical7, appointmentBtn);
		text7.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		text7.setTextAlignment(TextAlignment.JUSTIFY);
		text7.setFill(Color.WHITE);
		// Creating a shadow
		DropShadow shadow7 = new DropShadow();
		shadow7.setOffsetX(5);
		shadow7.setOffsetY(5);
		shadow7.setColor(Color.rgb(20, 20, 20, 0.5));
		text7.setEffect(shadow7);
		imagePic7.setEffect(shadow2);
		// Creating a DropShadow when cursor touch the box
		DropShadow shade7 = new DropShadow();
		box7.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				box7.setEffect(shade7);
			}
		});
		box7.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				box7.setEffect(null);
			}
		});
		// Create a hand cursor on object
		appointmentBtn.setCursor(Cursor.HAND);
		
		
		
		//BILING
		Rectangle bilingBox = new Rectangle();
		bilingBox.setWidth(250);
		bilingBox.setHeight(150);
		bilingBox.setFill(Color.web("#3D81CB"));
		bilingBox.setStrokeWidth(5);
		bilingBox.setStroke(Color.web("#73D2DD"));
		bilingBox.setArcHeight(20);
		bilingBox.setArcWidth(20);
		Button bilingBtn = new Button("");
		//bilingBtn.setPadding(new Insets(130, 250, 0, 0));
		bilingBtn.setStyle("-fx-background-color: transparent;");
		bilingBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Appointments appointments = new Appointments();
				try {
					appointments.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		// Image box 5
		Image bilingPic = new Image("images/biling.png");
		ImageView imagePicbiling = new ImageView(bilingPic);
		imagePicbiling.setFitWidth(90);
		imagePicbiling.setFitHeight(50);
		// Text box 5
		Text text8 = new Text("BILING");
		StackPane box8 = new StackPane();
		VBox vertical8 = new VBox(10, imagePicbiling, text8);
		vertical8.setAlignment(Pos.CENTER);
		box8.getChildren().addAll(bilingBox, vertical8, bilingBtn);
		text8.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 20));
		text8.setTextAlignment(TextAlignment.JUSTIFY);
		text8.setFill(Color.WHITE);
		// Creating a shadow
		DropShadow shadow8 = new DropShadow();
		shadow8.setOffsetX(5);
		shadow8.setOffsetY(5);
		shadow8.setColor(Color.rgb(20, 20, 20, 0.5));
		text8.setEffect(shadow8);
		imagePicbiling.setEffect(shadow2);
		// Creating a DropShadow when cursor touch the box
		DropShadow shadebiling = new DropShadow();
		box8.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				box8.setEffect(shadebiling);
			}
		});
		box8.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				box8.setEffect(null);
			}
		});
		// Create a hand cursor on object
		bilingBtn.setCursor(Cursor.HAND);
		
		
		
		
		

		// Logout Button
		Image logout = new Image("images/Log-01.png");
		ImageView imagePic8 = new ImageView(logout);
		imagePic8.setFitWidth(120);
		imagePic8.setFitHeight(120);

		Button logoutBtn = new Button("");
		logoutBtn.setPadding(new Insets(13, 95, 0, 0));
		logoutBtn.setStyle("-fx-background-color: transparent;");
		logoutBtn.setCursor(Cursor.HAND);
		logoutBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				LoginUI login = new LoginUI();
				try {
					login.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		BorderPane bp = new BorderPane();
		StackPane logoutStack = new StackPane(imagePic8, logoutBtn);
		logoutStack.setMaxWidth(-50);

		logoutStack.setAlignment(Pos.CENTER);

		DropShadow shade8 = new DropShadow();
		logoutStack.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				logoutStack.setEffect(shade8);
			}
		});
		logoutStack.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				logoutStack.setEffect(null);
			}
		});

		HBox h1 = new HBox(10, box1, box2, box3);
		h1.setAlignment(Pos.CENTER);
		HBox center = new HBox(10, box7, box8);
		center.setAlignment(Pos.CENTER);
		HBox h2 = new HBox(10, box4, box5, box6);
		h2.setAlignment(Pos.CENTER);

		VBox layout = new VBox(10, mainHeading, h1, h2, center, logoutStack);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 1800, 980);
		layout.setStyle("-fx-background-color:#2B7490");

		primaryStage.setTitle("DASHBOARD");
//		stage.setMaximized(true);
		stage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
