package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.service.UsuarioService;

public class LoginController{

	UsuarioService usuarioService = new UsuarioService();
	
	@FXML
	private TextField txtuser;
	
	@FXML
	private TextField txtpass;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void submit(ActionEvent event) throws IOException {
		
		String usuario = txtuser.getText();
		
		String contrasena = txtpass.getText();
		
		int rpt = usuarioService.validarIngreso(usuario, contrasena);
		
		if (rpt>0) {
			//Cargamos el menu
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Menu.fxml"));
			root = loader.load();
			//y pasamos el nombre de usuario
			MenuController menuController = loader.getController();
			menuController.cargarDatos(usuario);
			
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.centerOnScreen();
			stage.setScene(scene);
			stage.show();
			System.out.print("Bien");
		}else {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			
			Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
			Image icon = new Image(getClass().getResource("/images/x.png").toExternalForm());
			stage1.getIcons().add(icon);
			
			alert.setHeaderText("Usuario y/o contraseña erroneos");
			
			alert.showAndWait();
			
			System.out.print("Mal");
		}
		
	}
	
}
