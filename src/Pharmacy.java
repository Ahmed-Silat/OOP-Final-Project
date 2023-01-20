
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

public class Pharmacy extends Application {

//	public static void main(String[] args) {
//		launch(args);
//	}

	Stage stage;
	Scene scene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.setTitle("DRUG STORE");

		Text mainHeading = new Text();
		mainHeading.setText("PHARMACY\n");
		mainHeading.setFont(Font.font("Helvetica", FontWeight.BOLD, 50));
		mainHeading.setFill(Color.WHITE);

		Label lbl_medicineSN = new Label("Medicine Serial No");
		lbl_medicineSN.setTextFill(Color.WHITE);
		lbl_medicineSN.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		TextField txt_medicineSN = new TextField();
		txt_medicineSN.setPromptText("Enter Serial no");

		Label lbl_medicine = new Label("Medicine Name");
		lbl_medicine.setTextFill(Color.WHITE);
		lbl_medicine.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		TextField txt_medicine = new TextField();
		txt_medicine.setPromptText("Enter Medicine Name");

		Label lbl_company = new Label("Company Name");
		lbl_company.setTextFill(Color.WHITE);
		lbl_company.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		ComboBox<String> company_names = new ComboBox<>();
		company_names.setCursor(Cursor.HAND);
		company_names.setPromptText("Select");
		company_names.getItems().add("Getz Pharma");
		company_names.getItems().add("Abbott");
		company_names.getItems().add("Sanofi");
		company_names.getItems().add("GSK");
		company_names.getItems().add("Sami Pharma");
		company_names.getSelectionModel().getSelectedItem();

		Label lbl_manufacture = new Label("Date of Manufacture");
		lbl_manufacture.setTextFill(Color.WHITE);
		lbl_manufacture.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		DatePicker manufacture_date = new DatePicker();
		manufacture_date.setPromptText("Enter DOB");

		Label lbl_expiry = new Label("Date of Expiry");
		lbl_expiry.setTextFill(Color.WHITE);
		lbl_expiry.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		DatePicker expiry_date = new DatePicker();
		expiry_date.setPromptText("Enter DOE");

		Label lbl_quantity = new Label("Quantity");
		lbl_quantity.setTextFill(Color.WHITE);
		lbl_quantity.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));

		// Quantity Spinner
		final Spinner spinner = new Spinner();
		spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000));
		spinner.setEditable(true);

		// Go back button
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
		backButton.setStyle("-fx-background-color: transparent");

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

		// Main Heading
		HBox heading = new HBox(20, mainHeading);
		heading.setMargin(mainHeading, new Insets(0, 0, 0, 820));

		// Purchase button
		Button purchase = new Button();
		// purchase.setText("Purchase");
		purchase.setCursor(Cursor.HAND);
		HBox purchaseButton = new HBox(purchase);
		purchaseButton.setMargin(purchase, new Insets(50, 0, 0, 110));

		Image imgpurchase = new Image("images/purchase button-01.png");
		ImageView viewpurchase = new ImageView(imgpurchase);
		viewpurchase.setFitHeight(150);
		viewpurchase.setFitWidth(150);
		purchase.setGraphic(viewpurchase);
		purchase.setPadding(new Insets(-48, -10, -40, -10));
		purchase.setStyle("-fx-background-color: transparent");

		DropShadow shadowpurchase = new DropShadow();
		purchase.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				purchase.setEffect(shadowpurchase);
			}
		});
		purchase.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				purchase.setEffect(null);
			}
		});

		// Inside Material
		HBox medicineSN = new HBox(35, lbl_medicineSN, txt_medicineSN);
		HBox medicineName = new HBox(63, lbl_medicine, txt_medicine);
		HBox companyName = new HBox(61, lbl_company, company_names);
		HBox dateOfManufacture = new HBox(20, lbl_manufacture, manufacture_date);
		HBox dateOfExpiry = new HBox(80, lbl_expiry, expiry_date);
		HBox quantity = new HBox(128, lbl_quantity, spinner);

		VBox lbl_txt = new VBox(30, medicineSN, medicineName, companyName, dateOfManufacture, dateOfExpiry, quantity,
				purchaseButton);

		// Final Vertical Box
		VBox total = new VBox(goBack, heading, lbl_txt);
		total.setMargin(lbl_txt, new Insets(0, 0, 0, 780));

		purchase.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {

				String data = "";

				data += "\n\t\tMedicine Serial No: " + txt_medicineSN.getText() + "\n";
				data += "\t\tMedicine Name: " + txt_medicine.getText() + "\n";
				data += "\t\tCompany Name: " + company_names.getSelectionModel().getSelectedItem() + "\n";
				data += "\t\tDate Of Manufacture: " + manufacture_date.getValue() + "\n";
				data += "\t\tDate Of Expiry: " + expiry_date.getValue() + "\n";

				Alert a = new Alert(AlertType.INFORMATION);
				a.setContentText("\t\t\tMedicines Purchased\n" + data);
				a.show();

			}
		});

		total.setStyle("-fx-background-color:#5A8493");

		scene = new Scene(total, 800, 800);
		stage.setScene(scene);
		stage.show();

	}

}
