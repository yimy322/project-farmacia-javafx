package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Agregar icono
			Image icon = new Image(getClass().getResource("/images/logo.png").toExternalForm());
			primaryStage.getIcons().add(icon);
			
			//primaryStage.initStyle( StageStyle.UNDECORATED );
			primaryStage.setResizable(false);
			primaryStage.setTitle("Sistema de farmacia");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			primaryStage.setOnCloseRequest(event -> {
				event.consume();
				logout(primaryStage);
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logout(Stage stage) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		
		Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
		Image icon = new Image(getClass().getResource("/images/pregunta.png").toExternalForm());
		stage1.getIcons().add(icon);
		
		alert.setHeaderText("¿Esta seguro que desea salir?");
		
		if (alert.showAndWait().get() == ButtonType.OK) {
			System.out.println("Logout exitoso");
			stage.close();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
