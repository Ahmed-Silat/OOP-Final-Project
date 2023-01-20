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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Cardiologist extends Application {

//	public static void main(String[] args) {
//		launch(args);
//	}

	Stage stage;
	Scene scene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.setTitle("Book An Appointment");

		Text mainHeading = new Text();
		mainHeading.setText("CARDIOLOGIST\n");
		mainHeading.setFont(Font.font("Helvetica", FontWeight.BOLD, 50));
		mainHeading.setFill(Color.WHITE);

		Label lbl_patient = new Label("Patient ID");
		lbl_patient.setTextFill(Color.WHITE);
		lbl_patient.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		TextField txt_patient = new TextField();
		txt_patient.setPromptText("Enter Patient ID");

		Label lbl_name = new Label("Name");
		lbl_name.setTextFill(Color.WHITE);
		lbl_name.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		TextField txt_name = new TextField();
		txt_name.setPromptText("Enter Your Name");

		Label lbl_father = new Label("Father Name");
		lbl_father.setTextFill(Color.WHITE);
		lbl_father.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		TextField txt_father = new TextField();
		txt_father.setPromptText("Enter Father Name");

		Label lbl_gender = new Label("Gender");
		lbl_gender.setTextFill(Color.WHITE);
		lbl_gender.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		ToggleGroup rb_gp = new ToggleGroup();
		RadioButton rb_male = new RadioButton("Male");
		RadioButton rb_female = new RadioButton("Female");
		rb_male.setToggleGroup(rb_gp);
		rb_female.setToggleGroup(rb_gp);
		rb_male.setTextFill(Color.WHITE);
		rb_male.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		rb_female.setTextFill(Color.WHITE);
		rb_female.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));

		Label lbl_date = new Label("Date of Birth");
		lbl_date.setTextFill(Color.WHITE);
		lbl_date.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		DatePicker dob = new DatePicker();
		dob.setPromptText("Enter DOB");

		Label lbl_doctor = new Label("Doctor Name");
		lbl_doctor.setTextFill(Color.WHITE);
		lbl_doctor.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		ComboBox<String> dr_names = new ComboBox<>();
		dr_names.setPromptText("Select Doctor");
		dr_names.getItems().add("Dr. Ali Haider Naqvi");
		dr_names.getItems().add("Dr. Asif Mahmood");
		dr_names.getItems().add("Dr. Samiullah Khan");
		dr_names.getItems().add("Dr. Rameez Ahmed");
		dr_names.getSelectionModel().getSelectedItem();

		Label lbl_disease = new Label("Disease History");
		lbl_disease.setTextFill(Color.WHITE);
		lbl_disease.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		TextArea txt_disease = new TextArea();
		txt_disease.setPromptText("Enter Your Disease");

		HBox h1 = new HBox(75, lbl_patient, txt_patient);
		HBox h2 = new HBox(110, lbl_name, txt_name);
		HBox h3 = new HBox(48, lbl_father, txt_father);
		HBox h4 = new HBox(95, lbl_gender, rb_male, rb_female);
		h4.setMargin(rb_male, new Insets(-3, 0, 5, 0));
		h4.setMargin(rb_female, new Insets(-3, 0, 5, -80));
		HBox h5 = new HBox(48, lbl_date, dob);
		HBox h6 = new HBox(40, lbl_doctor, dr_names);

		VBox points = new VBox(40, h1, h2, h3, h4, h5, h6);
		VBox disease = new VBox(30, lbl_disease, txt_disease);

		HBox h = new HBox(25, points, disease);
		h.setMargin(disease, new Insets(0, 0, 0, 150));
		h.setAlignment(Pos.CENTER);

		HBox heading = new HBox(50, mainHeading);
		heading.setAlignment(Pos.CENTER);

		// save Button
		Button saveBtn = new Button();
		saveBtn.setCursor(Cursor.HAND);
		HBox save = new HBox(saveBtn);

		Image imgsave = new Image("images/save-01.png");
		ImageView viewsave = new ImageView(imgsave);
		viewsave.setFitHeight(150);
		viewsave.setFitWidth(150);
		saveBtn.setGraphic(viewsave);
		saveBtn.setPadding(new Insets(-40, -10, -40, 100));
//		saveBtn.setStyle("-fx-background-color: transparent");

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
		Button cancelBtn = new Button();
		cancelBtn.setCursor(Cursor.HAND);
		HBox cancel = new HBox(cancelBtn);

		Image imgcancel = new Image("images/cancel.png");
		ImageView viewcancel = new ImageView(imgcancel);
		viewcancel.setFitHeight(150);
		viewcancel.setFitWidth(150);
		cancelBtn.setGraphic(viewcancel);
		cancelBtn.setPadding(new Insets(-40, -20, -40, 5));
//		cancelBtn.setStyle("-fx-background-color: transparent");

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
		buttons.setMargin(saveBtn, new Insets(50, 30, 0, -105));
		buttons.setMargin(cancelBtn, new Insets(50, 30, 0, -50));

		// back button
		Button backButton = new Button();
		backButton.setCursor(Cursor.HAND);
		HBox goBack = new HBox(backButton);
		goBack.setMargin(backButton, new Insets(0, 100, 0, 0));

		Image imgback = new Image("images/backbutton-01.png");
		ImageView viewback = new ImageView(imgback);
		viewback.setFitHeight(150);
		viewback.setFitWidth(150);
		backButton.setGraphic(viewback);
		backButton.setPadding(new Insets(-40, -10, -40, -5));
//		backButton.setStyle("-fx-background-color: transparent");

		DropShadow shadowback = new DropShadow();
		backButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				backButton.setEffect(shadowback);
			}
		});
		backButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				backButton.setEffect(null);
			}
		});

		VBox mainVBox = new VBox(backButton, heading, h, buttons);

		saveBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {

				String info = "";
				String gender = "";

				info = "Patient ID: " + txt_patient.getText() + "\n";
				info += "Patient Name: " + txt_name.getText() + "\n";
				info += "Father Name: " + txt_father.getText() + "\n";

				if (rb_male.isSelected()) {
					gender = "Male";
				} else if (rb_female.isSelected()) {
					gender = "Female";
				} else {
					gender = "";
				}

				info += "Gender: " + gender + "\n";

				info += "Date Of Birth: " + dob.getValue() + "\n";

				info += "Doctor: " + dr_names.getSelectionModel().getSelectedItem() + "\n";

				info += "Disease History: " + txt_disease.getText();

				Alert a = new Alert(AlertType.INFORMATION);
				a.setContentText("Your appointment has been booked successfully!\n\n" + info);
				a.show();
			}
		});

		backButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub

			}
		});

		mainVBox.setStyle("-fx-background-color: #5A8493");

		scene = new Scene(mainVBox, 800, 800);
		stage.setScene(scene);
		stage.show();
	}
}
