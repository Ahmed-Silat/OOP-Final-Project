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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DeleteDoctor extends Application {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3308/hospitalManagementSystem";
	private static final String USER = "root";
	private static final String PASSWORD = "";

    @Override
    public void start(Stage primaryStage) {
        TableView<ObservableList<String>> tableView = new TableView<>();

        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            
            String query = "SELECT * FROM doctor";
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
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getString(i));
                }
                tableView.getItems().add(row);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Buttons
        Button backBtn = new Button("Go Back");
        backBtn.setCursor(Cursor.HAND);
        HBox goBack = new HBox(backBtn);
        backBtn.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        backBtn.setTextFill(Color.WHITE);
        backBtn.setStyle("-fx-background-color: blue; -fx-background-radius: 20px;");
        backBtn.setPadding(new Insets(0, 20, 0, 20));

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
        		AdminDashboard AdminDashboard = new AdminDashboard();
        		try {
        			AdminDashboard.start(primaryStage);
        		} catch (Exception e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}

        	}
        });
        
        HBox v = new HBox(10,goBack);
        
        Button saveButton = new Button("Save");
        saveButton.setCursor(Cursor.HAND);
        HBox save = new HBox(saveButton);
        saveButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        saveButton.setTextFill(Color.WHITE);
        saveButton.setStyle("-fx-background-color: green; -fx-background-radius: 20px;");
        saveButton.setPadding(new Insets(0, 20, 0, 20));

        DropShadow shadowback1 = new DropShadow();
        saveButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

        	@Override
        	public void handle(MouseEvent event) {
        		saveButton.setEffect(shadowback1);
        	}
        });
        saveButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent e) {
        		backBtn.setEffect(null);
        	}
        });

        saveButton.setOnAction(new EventHandler<ActionEvent>() {

        	@Override
        	public void handle(ActionEvent event) {
        		AdminDashboard AdminDashboard = new AdminDashboard();
        		try {
        			AdminDashboard.start(primaryStage);
        		} catch (Exception e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}

        	}
        });              
        
        Button cancelButton = new Button("Cancel");
        cancelButton.setCursor(Cursor.HAND);
        HBox cancel = new HBox(saveButton);
        cancelButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        cancelButton.setTextFill(Color.WHITE);
        cancelButton.setStyle("-fx-background-color: red; -fx-background-radius: 20px;");
        cancelButton.setPadding(new Insets(0, 20, 0, 20));

        DropShadow shadowback2 = new DropShadow();
        saveButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

        	@Override
        	public void handle(MouseEvent event) {
        		cancelButton.setEffect(shadowback2);
        	}
        });
        cancelButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent e) {
        		backBtn.setEffect(null);
        	}
        });

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {

        	@Override
        	public void handle(ActionEvent event) {
        		AdminDashboard AdminDashboard = new AdminDashboard();
        		try {
        			AdminDashboard.start(primaryStage);
        		} catch (Exception e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}

        	}
        });       
       

        HBox buttonBox = new HBox(30, saveButton, cancelButton);
        VBox root = new VBox(20, tableView, buttonBox, goBack);
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    

    public static void main(String[] args) {
        launch(args);
    }
}
