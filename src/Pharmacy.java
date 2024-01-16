
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout.Alignment;

import javafx.application.Application;
import javafx.collections.FXCollections;
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
import javafx.scene.control.Labeled;
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

	public static void main(String[] args) {
		launch(args);
	}

	Stage stage;
	Scene scene;
	TextField company_name;
	ComboBox<String> cmb_medicine;
	TextField manufacture_date;
	TextField expiry_date;
	TextField quantities;
	
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
		cmb_medicine = new ComboBox<>();
		cmb_medicine.setPromptText("Select Medicine");
        
        try {
        	cmb_medicine.getItems().addAll(Database.getColDataFromDb("pharmacy", "medicineName"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

		Label lbl_company = new Label("Company Name");
		lbl_company.setTextFill(Color.WHITE);
		lbl_company.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		company_name = new TextField();
		company_name.setCursor(Cursor.HAND);
		company_name.setEditable(false);
		
		Label lbl_manufacture = new Label("Date of Manufacture");
		lbl_manufacture.setTextFill(Color.WHITE);
		lbl_manufacture.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		manufacture_date = new TextField();
		manufacture_date.setPromptText("Enter DOB");

		Label lbl_expiry = new Label("Date of Expiry");
		lbl_expiry.setTextFill(Color.WHITE);
		lbl_expiry.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		expiry_date = new TextField();
		expiry_date.setPromptText("Enter DOE");

		Label lbl_quantity = new Label("Company Name");
		lbl_quantity.setTextFill(Color.WHITE);
		lbl_quantity.setFont(Font.font("Helvetica", FontWeight.LIGHT, 20));
		quantities = new TextField();
		quantities.setCursor(Cursor.HAND);
		quantities.setEditable(false);

//		// Quantity Spinner
//		final Spinner spinner = new Spinner();
//		spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000));
//		spinner.setEditable(true);

		// Go back button
		Button backBtn = new Button("Go Back");
		backBtn.setCursor(Cursor.HAND);
		HBox goBack = new HBox(backBtn);
		backBtn.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		backBtn.setTextFill(Color.WHITE);
		backBtn.setStyle("-fx-background-color: black; -fx-background-radius: 20px;");
		backBtn.setPadding(new Insets(0, 20, 0, 20));
		goBack.setMargin(backBtn, new Insets(5, 0, 0, 3));
		
		cmb_medicine.setOnAction(event -> {
			String selectedMedicine = cmb_medicine.getValue();
			if (selectedMedicine != null) {
				try {
					List<String> companyName = Database.getConditioinalDataFromDb("pharmacy", "companyName", "medicineName", selectedMedicine);
					List<String> dateOfManufacture = Database.getConditioinalDataFromDb("pharmacy", "dateOfManufacture", "medicineName", selectedMedicine);
					List<String> dateOfExpiry = Database.getConditioinalDataFromDb("pharmacy", "dateOfManufacture", "medicineName", selectedMedicine);
					List<String> quantityyy = Database.getConditioinalDataFromDb("pharmacy", "quantity", "medicineName", selectedMedicine);
					if (!quantityyy.isEmpty()) {
						String q = quantityyy.get(0);
						quantities.setText(null);
						quantities.setText(q);
					} else {
						quantities.setText("");
					}
					
					if (!dateOfExpiry.isEmpty()) {
						String dateExpiry = dateOfExpiry.get(0);
						expiry_date.setText(null);
						expiry_date.setText(dateExpiry);
					} else {
						expiry_date.setText("");
					}
					if (!dateOfManufacture.isEmpty()) {
						String dateManufacture = dateOfManufacture.get(0);
						manufacture_date.setText(null);
						manufacture_date.setText(dateManufacture);
					} else {
						manufacture_date.setText("");
					}
					if (!companyName.isEmpty()) {
						String name = companyName.get(0);
						company_name.setText(null);
						company_name.setText(name);
					} else {
						company_name.setText("");
					}
				} catch (SQLException e) {
					e.printStackTrace();
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
		Button purchaseBtn = new Button();
		purchaseBtn.setText("Purchase");
		purchaseBtn.setCursor(Cursor.HAND);
		HBox purchaseButton = new HBox(purchaseBtn);
		purchaseButton.setMargin(purchaseBtn, new Insets(30, 10, 0, 50));
		purchaseBtn.setFont(Font.font("Helvetica", FontWeight.BOLD, 30));
		purchaseBtn.setTextFill(Color.WHITE);
		purchaseBtn.setStyle("-fx-background-color: black; -fx-background-radius: 35px;");

		purchaseBtn.setPadding(new Insets(10, 50, 10, 50));

		DropShadow shadowpurchase = new DropShadow();
		purchaseBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				purchaseBtn.setEffect(shadowpurchase);
			}
		});
		purchaseBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				purchaseBtn.setEffect(null);
			}
		});

//		Inside Material
//		HBox medicineSN = new HBox(35, lbl_medicineSN, txt_medicineSN);
		HBox medicineName = new HBox(63, lbl_medicine, cmb_medicine);
		HBox companyName = new HBox(61, lbl_company, company_name);
		HBox dateOfManufacture = new HBox(20, lbl_manufacture, manufacture_date);
		HBox dateOfExpiry = new HBox(80, lbl_expiry, expiry_date);
		HBox quantity = new HBox(80, lbl_quantity, quantities);

		VBox lbl_txt = new VBox(30, medicineName, companyName, dateOfManufacture, dateOfExpiry, quantity,
				purchaseButton);

		// Final Vertical Box
		VBox total = new VBox(goBack, heading, lbl_txt);
		total.setMargin(lbl_txt, new Insets(0, 0, 0, 780));

		purchaseBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {

				String data = "";

//				data += "\n\t\tMedicine Serial No: " + txt_medicineSN.getText() + "\n";
//				data += "\t\tMedicine Name: " + ComboBox.getText() + "\n";
//				data += "\t\tCompany Name: " + company_names.getSelectionModel().getSelectedItem() + "\n";
//				data += "\t\tDate Of Manufacture: " + manufacture_date.getValue() + "\n";
//				data += "\t\tDate Of Expiry: " + expiry_date.getValue() + "\n";

				Alert a = new Alert(AlertType.INFORMATION);
				a.setContentText("\t\t\tMedicines Purchased\n" + data);
				a.show();

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
