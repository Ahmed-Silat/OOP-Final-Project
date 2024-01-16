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

public class UserAppointments extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		TableView<ObservableList<String>> tableView = new TableView<>();

		try {
			Connection connection = Database.getConnection();

			String tableName = "appointments";
			String colName = Database.getColumnNames(tableName, 2);

//			String query = "SELECT d.d_id, d.name, d.gender, d.dob, s.specializationNames " + "FROM doctor d "
//					+ "JOIN specializations s ON d.s_id=s.s_id";
			String query = "SELECT a.app_id, CONCAT(u.first_name, ' ' ,u.last_name) AS patientName, a.patient_email,"
					+ " d.name, s.specializationNames, a.DATE, a.disease FROM appointments a"
					+ " JOIN user u ON a.patient_id = u.u_id JOIN doctor d ON d.d_id = a.doctor_name"
					+ " JOIN specializations s ON s.s_id = a.consultant" + " WHERE a.patient_email = " + "\""
					+ UserAuthentication.getUserEmail() + "\"";

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
//				String doctorGender = resultSet.getString("gender");
//				String doctorDob = resultSet.getString("dob");
//                String doctorEmail = resultSet.getString("email");
//                String doctorPassword = resultSet.getString("password");

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
			UserDashboard userDashboard = new UserDashboard();
			try {
				userDashboard.start(primaryStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		HBox backButton = new HBox(10, goBack);

		VBox root = new VBox(10, backButton, tableView);
		Scene scene = new Scene(root, 1800, 980);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
