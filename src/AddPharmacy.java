
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.GroupLayout.Alignment;

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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddPharmacy extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	Stage stage;
	Scene scene;

	TextField txt_medicine;
	TextField txt_company;
	DatePicker manufacture_date;
	DatePicker expiry_date;
	TextField txt_price;
	@SuppressWarnings("rawtypes")
	Spinner spinner;

	public String getPharmacyDetails() {
		String medicineName = txt_medicine.getText();
		String companyName = txt_company.getText();
		LocalDate dateOfManufacture = manufacture_date.getValue();
		String formattedDateManufacture = dateOfManufacture.toString();
		LocalDate dateOfExpiry = expiry_date.getValue();
		String formattedDateExpiry = dateOfExpiry.toString();
		String quantity = (String) spinner.getValue();
		String price = txt_price.getText();
		System.out.println(medicineName + " " + companyName + " " + formattedDateManufacture + " " + formattedDateExpiry
				+ " " + quantity + " " + price);

//	    try {
//	        int specializationId = Database.getIdByCondition("specializations", "s_id", "specializationNames", cmb_specialization.getValue());
		return medicineName + " " + companyName + " " + formattedDateManufacture + " " + formattedDateExpiry + " "
				+ quantity + " " + price;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.setTitle("DRUG STORE");

		Text mainHeading = new Text();
		mainHeading.setText("PHARMACY\n");
		mainHeading.setFont(Font.font("Helvetica", FontWeight.BOLD, 50));
		mainHeading.setFill(Color.WHITE);

		Label lbl_medicine = new Label("Medicine Name");
		lbl_medicine.setTextFill(Color.WHITE);
		lbl_medicine.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		txt_medicine = new TextField();
		txt_medicine.setPromptText("Enter Medicine Name");

		Label lbl_company = new Label("Company Name");
		lbl_company.setTextFill(Color.WHITE);
		lbl_company.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		txt_company = new TextField();
		txt_company.setPromptText("Enter Medicine Name");

		Label lbl_manufacture = new Label("Date of Manufacture");
		lbl_manufacture.setTextFill(Color.WHITE);
		lbl_manufacture.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		manufacture_date = new DatePicker();
		manufacture_date.setPromptText("Enter DOB");

		Label lbl_expiry = new Label("Date of Expiry");
		lbl_expiry.setTextFill(Color.WHITE);
		lbl_expiry.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		expiry_date = new DatePicker();
		expiry_date.setPromptText("Enter DOE");

		Label lbl_quantity = new Label("Quantity");
		lbl_quantity.setTextFill(Color.WHITE);
		lbl_quantity.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));

		Label lbl_price = new Label("Price");
		lbl_price.setTextFill(Color.WHITE);
		lbl_price.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		txt_price = new TextField();
		txt_price.setPromptText("Enter Price");

		// Quantity Spinner
		spinner = new Spinner();
		spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000));
		spinner.setEditable(true);

		// Go back button
		Button backBtn = new Button("Go Back");
		backBtn.setCursor(Cursor.HAND);
		HBox goBack = new HBox(backBtn);
		backBtn.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		backBtn.setTextFill(Color.WHITE);
		backBtn.setStyle("-fx-background-color: black; -fx-background-radius: 20px;");
		backBtn.setPadding(new Insets(0, 20, 0, 20));
		goBack.setMargin(backBtn, new Insets(5, 0, 0, 3));

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

		// Main Heading
		HBox heading = new HBox(20, mainHeading);
		heading.setMargin(mainHeading, new Insets(170, 0, -20, 820));

		// Purchase button
		Button addBtn = new Button();
		addBtn.setText("Add");
		addBtn.setCursor(Cursor.HAND);
		HBox purchaseButton = new HBox(addBtn);
		purchaseButton.setMargin(addBtn, new Insets(30, 10, 0, 50));
		addBtn.setFont(Font.font("Helvetica", FontWeight.BOLD, 30));
		addBtn.setTextFill(Color.WHITE);
		addBtn.setStyle("-fx-background-color: black; -fx-background-radius: 35px;");

		addBtn.setPadding(new Insets(10, 50, 10, 50));

		DropShadow shadowpurchase = new DropShadow();
		addBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				addBtn.setEffect(shadowpurchase);
			}
		});
		addBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				addBtn.setEffect(null);
			}
		});

		// Inside Material
		HBox medicineName = new HBox(63, lbl_medicine, txt_medicine);
		HBox companyName = new HBox(61, lbl_company, txt_company);
		HBox dateOfManufacture = new HBox(20, lbl_manufacture, manufacture_date);
		HBox dateOfExpiry = new HBox(80, lbl_expiry, expiry_date);
		HBox quantity = new HBox(128, lbl_quantity, spinner);
		HBox price = new HBox(160, lbl_price, txt_price);

		VBox lbl_txt = new VBox(30, medicineName, companyName, dateOfManufacture, dateOfExpiry, quantity, price,
				purchaseButton);

		// Final Vertical Box
		VBox total = new VBox(goBack, heading, lbl_txt);
		total.setMargin(lbl_txt, new Insets(0, 0, 0, 780));

		addBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
//			public void handle(ActionEvent arg0) {
//
//				String data = "";
//
////				data += "\n\t\tMedicine Serial No: " + txt_medicineSN.getText() + "\n";
//				data += "\t\tMedicine Name: " + txt_medicine.getText() + "\n";
//				data += "\t\tCompany Name: " + txt_company.getText() + "\n";
//				data += "\t\tDate Of Manufacture: " + manufacture_date.getValue() + "\n";
//				data += "\t\tDate Of Expiry: " + expiry_date.getValue() + "\n";
//				data += "\t\tPrice: " + txt_price.getText() + "\n";
//
//				Alert a = new Alert(AlertType.INFORMATION);
//				a.setContentText("\t\t\tMedicines Purchased\n" + data);
//				a.show();
//
//			}
			public void handle(ActionEvent event) {
				try {
					if (validateFields()) {
						Database.insertIntoDb(getPharmacyDetails(), "pharmacy");
//						String data = "";
//
////						data += "\n\t\tMedicine Serial No: " + txt_medicineSN.getText() + "\n";
//						data += "\t\tMedicine Name: " + txt_medicine.getText() + "\n";
//						data += "\t\tCompany Name: " + txt_company.getText() + "\n";
//						data += "\t\tDate Of Manufacture: " + manufacture_date.getValue() + "\n";
//						data += "\t\tDate Of Expiry: " + expiry_date.getValue() + "\n";
//						data += "\t\tPrice: " + txt_price.getText() + "\n";
//
//						Alert a = new Alert(AlertType.INFORMATION);
//						a.setContentText("\t\t\tMedicines Purchased\n" + data);
//						a.showAndWait();
						Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
						successAlert.setContentText("Pharmacy added successfully!");
						successAlert.showAndWait();

//						txt_company.clear();
//						txt_medicine.clear();
//						manufacture_date.setValue(null);
//						expiry_date.setValue(null);
//						quantity.setValue(null);

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
					errorAlert.setContentText("Error occurred while adding the Pharmacy. Please try again.");
					errorAlert.showAndWait();
				}
			}

//			 Validate
			private boolean validateFields() {
				return !txt_medicine.getText().isEmpty() && txt_company.getText().isEmpty();
//						&& manufacture_date.getValue() != null && expiry_date.getValue() != null;
			}
		});

		total.setStyle("-fx-background-color: #2B7490");

		scene = new Scene(total, 1800, 980);
//		stage.setMaximized(true);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();

	}

}
