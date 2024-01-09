
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BillingUI extends Application {
	
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create GridPane layout for billing UI components
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Add components to GridPane
        Label lblPatientID = new Label("Patient ID:");
        TextField txtPatientID = new TextField();

        Label lblPatientName = new Label("Patient Name:");
        TextField txtPatientName = new TextField();

        Label lblAmount = new Label("Amount:");
        TextField txtAmount = new TextField();

        Button btnGenerateBill = new Button("Generate Bill");

        // Add components to GridPane layout
        gridPane.add(lblPatientID, 0, 0);
        gridPane.add(txtPatientID, 1, 0);
        gridPane.add(lblPatientName, 0, 1);
        gridPane.add(txtPatientName, 1, 1);
        gridPane.add(lblAmount, 0, 2);
        gridPane.add(txtAmount, 1, 2);
        gridPane.add(btnGenerateBill, 1, 3);

        // Create Scene and set GridPane as root
        Scene scene = new Scene(gridPane, 400, 200);

        // Set title and show the stage
        primaryStage.setTitle("Hospital Billing System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}

