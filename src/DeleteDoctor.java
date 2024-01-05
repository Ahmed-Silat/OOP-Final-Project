
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DeleteDoctor extends Application{
	Scene scene;
	Stage stage;
	
	
	public static void main(String[] args) {
		launch(args);

	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		
		TableView<DeleteDoctor> tableview = new TableView<>();

		TableColumn<DeleteDoctor, String> col1 = new TableColumn<>("DoctorID");
		col1.setCellValueFactory(new PropertyValueFactory<>("doctorId"));

		TableColumn<DeleteDoctor, String> col2 = new TableColumn<>("DoctorName");
		col2.setCellValueFactory(new PropertyValueFactory<>("doctorName"));

		TableColumn<DeleteDoctor, String> col3 = new TableColumn<>("FatherName");
		col3.setCellValueFactory(new PropertyValueFactory<>("fatherName"));

		TableColumn<DeleteDoctor, String> col4 = new TableColumn<>("Gender");
		col4.setCellValueFactory(new PropertyValueFactory<>("gender"));


		tableview.getColumns().add(col1);
		tableview.getColumns().add(col2);
		tableview.getColumns().add(col3);
		tableview.getColumns().add(col4);
		
		ObservableList<DeleteDoctor> oListStavaka;
		oListStavaka = FXCollections.observableArrayList();
		tableview.setItems(oListStavaka);

		Button backBtn = new Button("Go Back");
		backBtn.setCursor(Cursor.HAND);
		HBox goBack = new HBox(backBtn);
		backBtn.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		backBtn.setTextFill(Color.WHITE);
		backBtn.setStyle("-fx-background-color: blue; -fx-background-radius: 20px;");
		backBtn.setPadding(new Insets(0, 20, 0, 20));
//		goBack.setMargin(backBtn, new Insets(5, 0, 0, 3));

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
				UserDashboard userDashboard = new UserDashboard();
				try {
					userDashboard.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		VBox v = new VBox(10, goBack, tableview);
		scene = new Scene(v, 1800, 980);
		stage.setScene(scene);
		stage.show();

	}

		
	}
	


