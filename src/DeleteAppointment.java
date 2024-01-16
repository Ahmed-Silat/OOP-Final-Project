import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException;

public class DeleteAppointment extends Application {

	@Override
	public void start(Stage primaryStage) {
		TableView<ObservableList<String>> tableView = new TableView<>();

		try {
			Connection connection = Database.getConnection();

			String tableName = "doctor";
			String colName = Database.getColumnNames(tableName, 2);

			String query = "SELECT a.app_id, CONCAT(u.first_name, ' ' ,u.last_name) AS patientName, a.patient_email,"
					+ " d.name, s.specializationNames, a.DATE, a.disease FROM appointments a"
					+ " JOIN user u ON a.patient_id = u.u_id JOIN doctor d ON d.d_id = a.doctor_name"
					+ " JOIN specializations s ON s.s_id = a.consultant";

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();

			for (int i = 1; i <= columnCount; i++) {
				final int columnIndex = i - 1;
				TableColumn<ObservableList<String>, String> column = new TableColumn<>(metaData.getColumnName(i));
				column.setCellValueFactory(param -> {
					ObservableList<String> row = param.getValue();
					return new SimpleStringProperty(row.get(columnIndex));
				});
				tableView.getColumns().add(column);
			}

			while (resultSet.next()) {
				int doctorId = resultSet.getInt("app_id");
				String patientName = resultSet.getString("patientName");
				String patientEmail = resultSet.getString("patient_email");
				String doctorName = resultSet.getString("name");
				String specialization = resultSet.getString("specializationNames");
				String date = resultSet.getString("DATE");
				String disease = resultSet.getString("disease");

				tableView.getItems().add(FXCollections.observableArrayList(String.valueOf(doctorId), patientName,
						patientEmail, doctorName, specialization, date, disease));
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Buttons

		// Go back button
		Button backBtn = new Button("Go Back");
		backBtn.setCursor(Cursor.HAND);
		HBox goBack = new HBox(backBtn);
		backBtn.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		backBtn.setTextFill(Color.WHITE);
		backBtn.setStyle("-fx-background-color: black; -fx-background-radius: 20px;");
		backBtn.setPadding(new Insets(0, 20, 0, 20));

		DropShadow shadowBack = new DropShadow();
		backBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> backBtn.setEffect(shadowBack));
		backBtn.addEventHandler(MouseEvent.MOUSE_EXITED, event -> backBtn.setEffect(null));

		backBtn.setOnAction(event -> {
			AdminDashboard adminDashboard = new AdminDashboard();
			try {
				adminDashboard.start(primaryStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		// Delete button
		Button deleteButton = new Button("Delete");
		deleteButton.setCursor(Cursor.HAND);
		deleteButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		deleteButton.setTextFill(Color.WHITE);
		deleteButton.setStyle("-fx-background-color: black; -fx-background-radius: 20px;");
		deleteButton.setPadding(new Insets(0, 20, 0, 20));

		DropShadow shadowDelete = new DropShadow();
		deleteButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> deleteButton.setEffect(shadowDelete));
		deleteButton.addEventHandler(MouseEvent.MOUSE_EXITED, event -> deleteButton.setEffect(null));

		deleteButton.setOnAction(event -> {
			ObservableList<String> selectedItem = tableView.getSelectionModel().getSelectedItem();

			if (selectedItem != null) {
				String primaryKeyColumnName = tableView.getColumns().get(0).getText();
				String primaryKeyValue = selectedItem.get(0); // Assuming the first column is the primary key

				// Call the generalization method for deletion
				Database.deleteRecord("appointments", primaryKeyColumnName, primaryKeyValue);

				// Remove the selected item from the TableView
				tableView.getItems().remove(selectedItem);
			} else {
				// Display a message or handle the case where no item is selected
				System.out.println("No item selected for deletion.");
			}
		});

		HBox backButton = new HBox(10, goBack);

		VBox root = new VBox(10, backButton, tableView, deleteButton);
		Scene scene = new Scene(root, 1800, 980);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
