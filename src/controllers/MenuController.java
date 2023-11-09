package controllers;

import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import models.entity.*;
import models.service.*;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.animation.KeyFrame;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuController {
	
	//Llamamos a los services
	
	ProveedorService proveedorService = new ProveedorService();
	
	//---------------------------------

	@FXML
	Label lblusuario;

	@FXML
	Label lblfecha;
	
	//buttons
	@FXML
	Button btnPrincipal;
	
	@FXML
	Button btnVentas;
	
	@FXML
	Button btnClientes;
	
	@FXML
	Button btnProveedores;
	
	@FXML
	Button btnProductos;
	
	@FXML
	Button btnUsuarios;
	
	@FXML
	Button btnInventario;
	
	//---------------------------------
	
	//Botones de reportes
	
	@FXML
	Button btnExcelPro;
	
	@FXML
	Button btnJsonPro;
	
	//---------------------------------
	
	//PANELES
	@FXML
	AnchorPane panelPrincipal;
	
	@FXML
	AnchorPane panelVentas;
	
	@FXML
	AnchorPane panelProductos;
	
	@FXML
	AnchorPane panelProveedores;
	
	@FXML
	AnchorPane panelClientes;
	
	@FXML
	AnchorPane panelAdmin;
	
	@FXML
	AnchorPane panelInventario;
	
	//Cajas de texto de proveedores
	
	@FXML
	TextField txtProId;
	
	@FXML
	TextField txtProNombre;
	
	@FXML
	TextField txtProDireccion;
	
	@FXML
	TextField txtProTelefono;
	
	@FXML
	TextField txtProNacionalidad;
	
	@FXML
	TextField busquedaPro;
	
	//Cajas de texto de productos
	
	@FXML
	TextField txtProdId;
	
	@FXML
	TextField txtProdNombre;
	
	@FXML
	TextField txtProdPrecio;
	
	@FXML
	TextField txtProdStock;
	
	@FXML
	DatePicker txtProdFecha;
	
	@FXML
	ComboBox<String> txtProdPro;
	
	//---------------------------------
	
	//Buttons de proveedores
	@FXML
	Button btnRegistrarPro;
	
	@FXML
	Button btnActualizarPro;
	
	@FXML
	Button btnEliminarPro;
	
	//Buttons de productos
	@FXML
	Button btnRegistrarProd;
		
	@FXML
	Button btnActualizarProd;
		
	@FXML
	Button btnEliminarProd;
	//---------------------------------
	//Tablas
	@FXML
	TableView<Proveedor> tblProveedores;//esta table tendra objetos del tipo Proveedor
	
	//Columnas
	@FXML
	TableColumn<Proveedor, Integer> colProId;
	
	@FXML
	TableColumn<Proveedor, String> colProNom;
	
	@FXML
	TableColumn<Proveedor, String> colProTe;
	
	@FXML
	TableColumn<Proveedor, String> colProDi;
	
	@FXML
	TableColumn<Proveedor, String> colProNa;
	
	
	//------------------------------------------------------------------------------------
	
	//esta clase tiene la capacidad de notificar a sus observadores cuando se produce algun cambio
	ObservableList<Proveedor> listaObservable;//clase

	public void cargarDatos(String usuario) {

		lblusuario.setText(usuario);
		
	}
	
	//metodos para cambiar de panel
	public void irVentas(ActionEvent event) {
		
		panelPrincipal.setVisible(false);
		btnPrincipal.setStyle("-fx-background-color: #048863; ");
		
		panelVentas.setVisible(true);
		btnVentas.setStyle("-fx-background-color: #1b2223; ");
		
		panelProductos.setVisible(false);
		btnProductos.setStyle("-fx-background-color: #048863; ");
		
		panelProveedores.setVisible(false);
		btnProveedores.setStyle("-fx-background-color: #048863; ");
		
		panelClientes.setVisible(false);
		btnClientes.setStyle("-fx-background-color: #048863; ");
		
		panelAdmin.setVisible(false);
		btnUsuarios.setStyle("-fx-background-color: #048863; ");
		
		panelInventario.setVisible(false);
		btnInventario.setStyle("-fx-background-color: #048863; ");
		
	}
	
	public void irPrincipal(ActionEvent event) {
		
		panelPrincipal.setVisible(true);
		btnPrincipal.setStyle("-fx-background-color: #1b2223; ");
		
		panelVentas.setVisible(false);
		btnVentas.setStyle("-fx-background-color: #048863; ");
		
		panelProductos.setVisible(false);
		btnProductos.setStyle("-fx-background-color: #048863; ");
		
		panelProveedores.setVisible(false);
		btnProveedores.setStyle("-fx-background-color: #048863; ");
		
		panelClientes.setVisible(false);
		btnClientes.setStyle("-fx-background-color: #048863; ");
		
		panelAdmin.setVisible(false);
		btnUsuarios.setStyle("-fx-background-color: #048863; ");
		
		panelInventario.setVisible(false);
		btnInventario.setStyle("-fx-background-color: #048863; ");
		
	}
	
	public void irProductos(ActionEvent event) {
		
		panelPrincipal.setVisible(false);
		btnPrincipal.setStyle("-fx-background-color: #048863; ");
		
		panelVentas.setVisible(false);
		btnVentas.setStyle("-fx-background-color: #048863; ");
		
		panelProductos.setVisible(true);
		btnProductos.setStyle("-fx-background-color: #1b2223; ");
		
		panelProveedores.setVisible(false);
		btnProveedores.setStyle("-fx-background-color: #048863; ");
		
		panelClientes.setVisible(false);
		btnClientes.setStyle("-fx-background-color: #048863; ");
		
		panelAdmin.setVisible(false);
		btnUsuarios.setStyle("-fx-background-color: #048863; ");
		
		panelInventario.setVisible(false);
		btnInventario.setStyle("-fx-background-color: #048863; ");
		
	}
	
	public void irProveedores(ActionEvent event) {
		
		panelPrincipal.setVisible(false);
		btnPrincipal.setStyle("-fx-background-color: #048863; ");
		
		panelVentas.setVisible(false);
		btnVentas.setStyle("-fx-background-color: #048863; ");
		
		panelProductos.setVisible(false);
		btnProductos.setStyle("-fx-background-color: #048863; ");
		
		panelProveedores.setVisible(true);
		btnProveedores.setStyle("-fx-background-color: #1b2223; ");
		
		panelClientes.setVisible(false);
		btnClientes.setStyle("-fx-background-color: #048863; ");
		
		panelAdmin.setVisible(false);
		btnUsuarios.setStyle("-fx-background-color: #048863; ");
		
		panelInventario.setVisible(false);
		btnInventario.setStyle("-fx-background-color: #048863; ");
		
	}
	
	public void irClientes(ActionEvent event) {
		
		panelPrincipal.setVisible(false);
		btnPrincipal.setStyle("-fx-background-color: #048863; ");
		
		panelVentas.setVisible(false);
		btnVentas.setStyle("-fx-background-color: #048863; ");
		
		panelProductos.setVisible(false);
		btnProductos.setStyle("-fx-background-color: #048863; ");
		
		panelProveedores.setVisible(false);
		btnProveedores.setStyle("-fx-background-color: #048863; ");
		
		panelClientes.setVisible(true);
		btnClientes.setStyle("-fx-background-color: #1b2223; ");
		
		panelAdmin.setVisible(false);
		btnUsuarios.setStyle("-fx-background-color: #048863; ");
		
		panelInventario.setVisible(false);
		btnInventario.setStyle("-fx-background-color: #048863; ");
		
	}
	
	public void irAdmin(ActionEvent event) {
		
		panelPrincipal.setVisible(false);
		btnPrincipal.setStyle("-fx-background-color: #048863; ");
		
		panelVentas.setVisible(false);
		btnVentas.setStyle("-fx-background-color: #048863; ");
		
		panelProductos.setVisible(false);
		btnProductos.setStyle("-fx-background-color: #048863; ");
		
		panelProveedores.setVisible(false);
		btnProveedores.setStyle("-fx-background-color: #048863; ");
		
		panelClientes.setVisible(false);
		btnClientes.setStyle("-fx-background-color: #048863; ");
		
		panelAdmin.setVisible(true);
		btnUsuarios.setStyle("-fx-background-color: #1b2223; ");
		
		panelInventario.setVisible(false);
		btnInventario.setStyle("-fx-background-color: #048863; ");
		
	}
	
	public void irInventario(ActionEvent event) {
		
		panelPrincipal.setVisible(false);
		btnPrincipal.setStyle("-fx-background-color: #048863; ");
		
		panelVentas.setVisible(false);
		btnVentas.setStyle("-fx-background-color: #048863; ");
		
		panelProductos.setVisible(false);
		btnProductos.setStyle("-fx-background-color: #048863; ");
		
		panelProveedores.setVisible(false);
		btnProveedores.setStyle("-fx-background-color: #048863; ");
		
		panelClientes.setVisible(false);
		btnClientes.setStyle("-fx-background-color: #048863; ");
		
		panelAdmin.setVisible(false);
		btnUsuarios.setStyle("-fx-background-color: #048863; ");
		
		panelInventario.setVisible(true);
		btnInventario.setStyle("-fx-background-color: #1b2223; ");
		
	}
	
	//se llama automaticamente cuando se carga el controlador
	public void initialize() {	
		//estos metodos son los encargados de la desactivacion de los buttons
		validarProveedor();
		validarProducto();
		//Para que cuando se inicie automaticamente se ponga en el panel principal
		irPrincipal(null);
		fecha();
		//UN KEYframe representa un fotograma y se ejecutara cada segundo
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
        	fecha();
        }));
        //aca configuramos la linea de tiempo
        timeline.setCycleCount(Timeline.INDEFINITE);//se ejecutara indifinidamente
        timeline.play();//lo iniciamos
        
        //cargamos las tablas de la bd en los tableview
        listarProveedores();
        
        //cargamos combos
        cargarComboProveedor();
        
        //cargamos el buscador
        busquedaDatos();
        
        //para setear la fila en las cajas
        tblProveedores.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        	if (newValue != null) {
				txtProId.setText(newValue.getId()+"");
				txtProNombre.setText(newValue.getNombre());
				txtProTelefono.setText(newValue.getTelefono());
				txtProDireccion.setText(newValue.getDireccion());
				txtProNacionalidad.setText(newValue.getNacionalidad());
			}	        
	    });	 
    }
	
	//Metodo para obtener la fecha actual
	public void fecha() {	
        Date now = new Date();
    	// Formatear la fecha y la hora
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = dateFormat.format(now);
        lblfecha.setText(formattedDateTime);
	}
	
//------------------------PROVEEDOR-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	public void validarProveedor() {	
		//Utilizamos un StringConverter para convertir el texto en un número
		//el StringConverter es una interfaz que se utiliza para convertir en este caso la cadena en un entero por eso usamos el IntegerStringConverter que es un aimplementacion de la interfaz ya mencionada
        StringConverter<Integer> convertidor = new IntegerStringConverter();
        //Definimos un filtro de TextFormatter para permitir solo números y limitar la longitud.
        //el textformatter se utiliza para dar formato y validar texto
        TextFormatter<Integer> formatoTexto = new TextFormatter<>(convertidor, null, change -> {//el text formarte recibe 3 parametros, el converter, el valor por defecto y un change que ahi es un lambda
            //el change funciona como un filtro para el texto ingresado en el textfield, cuando se ingresa texto en el campo, esta función se ejecuta
        	String nuevoTexto = change.getControlNewText();//obtiene el texto ingresado
        	//el metodo matches se utiliza para comprobar si una cadena de texto cumple con un patrón definido por una expresión regular
        	//una expresion regular es una secuencia de caracteres que define un patrón de búsqueda en un texto
            if (nuevoTexto.matches("\\d*") && nuevoTexto.length() <= 9) {//la expresión regular \\d* significa "0 - 9" y el otro evalua la longitud
                return change;//si se cumple el cambio se acepta y se muestra en el textfield
            } else {
                return null;//de lo contrario se impide que el nuevo texto se muestre en el textfield
            }
        });
        txtProTelefono.setTextFormatter(formatoTexto);//aca damos el formato al textfield
        //Llamamos al metodo que no permitira que metamos espacios en los textfield
        //creamos una instancia de textFormatter para evitar una exception
        TextFormatter<String> sinEspacios = validarEspacios();
        TextFormatter<String> sinEspacios1 = validarEspacios();
        TextFormatter<String> sinEspacios2 = validarEspacios();
        txtProNombre.setTextFormatter(sinEspacios);
        txtProDireccion.setTextFormatter(sinEspacios1);
        txtProNacionalidad.setTextFormatter(sinEspacios2);
        //metodo para que si la caja del id este vacia los buttons de eliminar y actualizar esten desactivados 
        BooleanBinding desactivarBtn = Bindings.createBooleanBinding(//construimos una condicion logica para verificar si las cajas estan vacias, este metodo recibe dos argumentos
	            () -> txtProId.getText().isEmpty(),//definimos la condicion logica
	            txtProId.textProperty()
	    );
		//Es una expresion para crear condiciones logicas
        //se utiliza para controlar la habilitación o deshabilitación de algún componente gráfico, como un botón, en función de una condición boolean
		BooleanBinding cajasVacias = Bindings.createBooleanBinding(//construimos una condicion logica para verificar si las cajas estan vacias, este metodo recibe dos argumentos
	            () -> txtProNombre.getText().isEmpty() || txtProDireccion.getText().isEmpty() || txtProNacionalidad.getText().isEmpty() || txtProTelefono.getText().isEmpty() || !txtProId.getText().isEmpty(),//definimos la condicion logica
	            txtProNombre.textProperty(),//el textproperty se encarga de observar el componente, de escuchar los cambios
	            txtProDireccion.textProperty(),
	            txtProTelefono.textProperty(),
	            txtProNacionalidad.textProperty()
	    );
		//el disableproperty se utiliza para deshabilitar un nodo(un nodo es un elemento grafico)
		btnRegistrarPro.disableProperty().bind(cajasVacias);//el bind es para vincular y si la condicion cambia la propiedad del button se actualiza 
		//si es true el btn se desahibilitara sino lo contrario
		btnActualizarPro.disableProperty().bind(desactivarBtn);
		btnEliminarPro.disableProperty().bind(desactivarBtn);
	}
	
	public void registrarProveedor(ActionEvent event){
		
		//Capturamos datos
		String nombre = txtProNombre.getText();
		String telefono = txtProTelefono.getText();
		String direccion = txtProDireccion.getText();
		String nacionalidad = txtProNacionalidad.getText();
		
		if(telefono.length() < 9) {
			//--Creacion de un alert
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			
			Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
			Image icon = new Image(getClass().getResource("/images/x.png").toExternalForm());
			stage1.getIcons().add(icon);
			
			alert.setHeaderText("La longitud del campo numero no es valida");
			
			alert.showAndWait();
			//-------------
			System.out.print("No valido");
		}else {
			
			//Llamamos al metodo save del service para guardar en la bd, este metodo recibe como paremetro un objeto de tipo Proveedor
			int valor = proveedorService.save(new Proveedor(nombre, telefono, direccion, nacionalidad));//como retorna un entero lo guardamos en un variables para comprobar
			
			if (valor != 0) {
				//--Creacion de un alert
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Datos guardados");
				
				Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
				Image icon = new Image(getClass().getResource("/images/check.png").toExternalForm());
				stage1.getIcons().add(icon);
				
				alert.setHeaderText("Proveedor guardado correctamente");
				
				alert.showAndWait();
				//-------------
				//Limpiamos las cajas
				txtProNombre.setText("");
				txtProDireccion.setText("");
				txtProTelefono.setText("");
				txtProNacionalidad.setText("");
			}else {
				//--Creacion de un alert
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				
				Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
				Image icon = new Image(getClass().getResource("/images/x.png").toExternalForm());
				stage1.getIcons().add(icon);
				
				alert.setHeaderText("Ocurrio algun error en la base de datos");
				
				alert.showAndWait();
				//-------------
			}
			
		}
		
		listarProveedores();
		
		//actualizamos el combo que se mostrara en productos
		cargarComboProveedor();
		
	}
	
	public void listarProveedores(){
		
		// un ObservableList es una lista que puede notificar a los observadores cuando se realizan cambios en la lista
		listaObservable = FXCollections.observableArrayList(proveedorService.findAll());
		//el metodo observableArrayList genera una lista que se comporta como un ObservableList, lo que significa que puedes agregar, eliminar o modificar elementos en la lista, y cualquier cambio se notificara automaticamente a la interfaz de usuario 
		//si modificas esta lista, la tabla se actualizara para reflejar esos cambios.
		
		colProId.setCellValueFactory(new PropertyValueFactory<>("id"));//aca mostramos los datos en la columna segun el nombre del atributo de la entidad
		
		colProNom.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		
		colProTe.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		
		colProDi.setCellValueFactory(new PropertyValueFactory<>("direccion"));
		
		colProNa.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));
		
		tblProveedores.setItems(listaObservable);//no hay necesidad de iterar los registros e ir seteando, cada vez que la lista observable cambie se actualizaran los datos
		
	}
	
	public void eliminarProveedores() {
		///Guardamos en una variable el id
		int id = Integer.parseInt(txtProId.getText());//lo capturamos de la caja de texto
		Proveedor pro = proveedorService.findById(new Proveedor(id));//llamamos al service para buscar el proveedor y le pasamos el objeto proveedor que con tiene el id
		int validar = proveedorService.delete(pro);//aca volvemos a llamar al service y lo borramos
		if (validar!=0) {
			//--Creacion de un alert
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Eliminado");
			Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
			Image icon = new Image(getClass().getResource("/images/check.png").toExternalForm());
			stage1.getIcons().add(icon);
			alert.setHeaderText("Proveedor eliminado con exito");
			alert.showAndWait();
			//-------------
			txtProId.setText("");
			txtProNombre.setText("");
			txtProTelefono.setText("");
			txtProDireccion.setText("");
			txtProNacionalidad.setText("");
			txtProNombre.requestFocus();
			listarProveedores();//actualizamos la tabla
			//actualizamos el combo que se mostrara en productos
			cargarComboProveedor();
		}else {
			System.out.println("Error");
		}
	}
	
	public void actualizarProveedores() {
		int id = Integer.parseInt(txtProId.getText());
		String nombre = txtProNombre.getText();
		String telefono = txtProTelefono.getText();
		String direccion = txtProDireccion.getText();
		String nacionalidad = txtProNacionalidad.getText();
		int validar = proveedorService.update(new Proveedor(id, nombre, telefono, direccion, nacionalidad));
		if (validar!=0) {
			//--Creacion de un alert
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Actualizado");
			Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
			Image icon = new Image(getClass().getResource("/images/check.png").toExternalForm());
			stage1.getIcons().add(icon);
			alert.setHeaderText("Proveedor actualizado con exito");
			alert.showAndWait();
			//-------------
			txtProId.setText("");
			txtProNombre.setText("");
			txtProTelefono.setText("");
			txtProDireccion.setText("");
			txtProNacionalidad.setText("");
			txtProNombre.requestFocus();
			listarProveedores();//actualizamos la tabla
			//actualizamos el combo que se mostrara en productos
			cargarComboProveedor();
		}else {
			System.out.println("Error");
		}
	}
	
	public void limpiarProveedores(ActionEvent event) {
		txtProId.setText("");
		txtProNombre.setText("");
		txtProTelefono.setText("");
		txtProDireccion.setText("");
		txtProNacionalidad.setText("");
		txtProNombre.requestFocus();
	}
	
	
//------------------------PRODUCTOS-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	public void validarProducto() {
		TextFormatter<String> formatoTexto = new TextFormatter<>(change -> {
		    String nuevoTexto = change.getControlNewText();
		    if (nuevoTexto.matches("^(\\d+)?(\\.\\d{0,2})?$")) {//esta expresion regular es para monedas
		        return change;
		    } else {
		        return null;
		    }
		});
		StringConverter<Integer> convertidor = new IntegerStringConverter();
        TextFormatter<Integer> formatoTexto1 = new TextFormatter<>(convertidor, null, change -> {
        	String nuevoTexto = change.getControlNewText();
            if (nuevoTexto.matches("\\d*")) {//la expresión regular
                return change;//si se cumple el cambio se acepta y se muestra en el textfield
            } else {
                return null;//de lo contrario se impide que el nuevo texto se muestre en el textfield
            }
        });
        txtProdPrecio.setTextFormatter(formatoTexto);//aca damos el formato al textfield
        txtProdStock.setTextFormatter(formatoTexto1);
        //Llamamos al metodo que no permitira que metamos espacios en los textfield
        //creamos una instancia de textFormatter para evitar una exception
        TextFormatter<String> sinEspacios = validarEspacios();
        txtProdNombre.setTextFormatter(sinEspacios);
        //metodo para que si la caja del id este vacia los buttons de eliminar y actualizar esten desactivados 
        BooleanBinding desactivarBtn = Bindings.createBooleanBinding(//construimos una condicion logica para verificar si las cajas estan vacias, este metodo recibe dos argumentos
	            () -> txtProId.getText().isEmpty(),//definimos la condicion logica
	            txtProId.textProperty()
	    );
		//Es una expresion para crear condiciones logicas
        //se utiliza para controlar la habilitación o deshabilitación de algún componente gráfico, como un botón, en función de una condición boolean
		BooleanBinding cajasVacias = Bindings.createBooleanBinding(//construimos una condicion logica para verificar si las cajas estan vacias, este metodo recibe dos argumentos
	            () -> txtProdNombre.getText().isEmpty() || txtProdPrecio.getText().isEmpty() || txtProdStock.getText().isEmpty() || !txtProdId.getText().isEmpty(),//definimos la condicion logica
	            txtProdNombre.textProperty(),//el textproperty se encarga de observar el componente, de escuchar los cambios
	            txtProdPrecio.textProperty(),
	            txtProdStock.textProperty()
	    );
		//el disableproperty se utiliza para deshabilitar un nodo(un nodo es un elemento grafico)
		btnRegistrarProd.disableProperty().bind(cajasVacias);//el bind es para vincular y si la condicion cambia la propiedad del button se actualiza 
		//si es true el btn se desahibilitara sino lo contrario
		btnActualizarProd.disableProperty().bind(desactivarBtn);
		btnEliminarProd.disableProperty().bind(desactivarBtn);
	}
	
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Método para no permitir espacios en blanco en las cajas
    public TextFormatter<String> validarEspacios() {
        StringConverter<String> convertidor = new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return object;
            }
            //El metodo se encarga de eliminar los espacios
            @Override
            public String fromString(String string) {
                return string.trim();//el trim elimina los espacios en blanco
            }
        };

        TextFormatter<String> quitarEspacios = new TextFormatter<>(convertidor, null, change -> {//el change funciona como un filtro para el texto ingresado en el textfield, cuando se ingresa texto en el campo, esta función se ejecuta
            String nuevoTexto = change.getControlNewText();
            if (nuevoTexto.startsWith(" ") && !nuevoTexto.trim().equals(nuevoTexto)) {//esta expresión verifica si el texto comienza con un espacio en blanco y si después de eliminar los espacios en blanco al principio y al final sigue siendo diferente del texto original
                return null;//de lo contrario se impide que el nuevo texto se muestre en el textfield
            } else if(nuevoTexto.length() <= 25){
                return change;//si se cumple el cambio se acepta y se muestra en el textfield
            }else {
                return null;//de lo contrario se impide que el nuevo texto se muestre en el textfield
            }
        });

        return quitarEspacios;
    }
	
//----------------------------------CARGAR COMBOS--------------------------------------------------
	public void cargarComboProveedor() {
		int j = 0;
		//un observableList es una lista dinamica, osea que se actualizara automaticamente cuando haya mas datos
		ObservableList<String> items = FXCollections.observableArrayList();
		for(Proveedor e:proveedorService.findAll()) {
			if(j==0) {
				txtProdPro.getSelectionModel().select(e.getNombre());
				j++;
			}
			items.add(e.getNombre());	
		}
		//Borramos los elementos ya existentes en el combo para cargar los nuevos
		txtProdPro.getItems().clear();
		txtProdPro.getItems().addAll(items);
	}
	
//---------------------------------------------------EXPORTAR EXCEL-----------------------------------------------------------------------------------------------------------------------------------
	public void generarExcelPro(ActionEvent event) {
		// Crear un nuevo libro de Excel
		Workbook workbook = new XSSFWorkbook();
		// Crear una hoja en el libro
		Sheet sheet = workbook.createSheet("Datos");
		// Crear una lista para almacenar los datos como filas de texto
		List<ObservableList<String>> data = new ArrayList<>();
		// Obtener los datos de la tabla en JavaFX y convertirlos a filas de texto
		for (Proveedor proveedor : tblProveedores.getItems()) {//el getItems es para obtener la lista de elementos de la tabla
		    ObservableList<String> rowData = FXCollections.observableArrayList(
		        String.valueOf(proveedor.getId()),
		        proveedor.getNombre(),
		        proveedor.getTelefono(),
		        proveedor.getDireccion(),
		        proveedor.getNacionalidad()
		    );
		    data.add(rowData);
		}
		//iniciamos un contador que se usara para llevar un seguimiento de las filas en la hoja de Excel
		int cont = 0;
		//LO QUE HARA ESOS BUCLES ES RECORRER CADA FILA Y CELDA PARA PONER LOS DATOS EN LA HOJA EXCEL
		// iteramos a traves de los datos y los escribimos en la hoja de Excel
		for (ObservableList<String> e : data) {
		    Row row = sheet.createRow(cont);//aca creamos una nueva fila en la hoja del excel
		    int cellIndex = 0;//se utilizara para determinar en que posicion de la fila se creara la celda
		    for (String cellData : e) {
		        Cell cell = row.createCell(cellIndex);//creamos una celda
		        cell.setCellValue(cellData);//se establece el valor de la celda con el contenido correspondiente de la fila de datos 
		        cellIndex++;
		    }
		    cont++;
		}
		//crear una interfaz para poder guardar archivos etc
		FileChooser chooser = new FileChooser();
		//aca se aplica como un filtro para que me muestre los archivos de tipo excel y con extension xlsx
		chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos Excel", "*.xlsx"));
		//aca le ponemos el nombre inicial
		chooser.setInitialFileName("tabla_excel.xlsx");
		// Obtiene el Stage principal del controlador
        Stage stage = (Stage) btnExcelPro.getScene().getWindow(); 
        //se muestra el chooser y la ruta obtenida se guarda el file
		File file = chooser.showSaveDialog(stage);
		//validamos
		if (file != null) {
		    try{
		    	//se utiliza para escribir datos en un archivo en el sistema de archivos local
		    	FileOutputStream fileOut = new FileOutputStream(file);
		    	workbook.write(fileOut);//lo escribimos dentro del libro
		        abrirFile(file.toString());//este metodo abrira el archivo
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	}
//---------------------------------------------------GENERAR JSON-----------------------------------------------------------------------------------------------------------------------------------
	public void generarJsonPro(ActionEvent event) {
		// Obtén los datos de la tabla
        List<Proveedor> data = proveedorService.findAll();
        //crear una interfaz para poder guardar archivos etc
        FileChooser chooser = new FileChooser();
      	//aca se aplica como un filtro para que me muestre los archivos de tipo excel y con extension xlsx
      	chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Todos los Archivos", "*.json"));
      	//aca le ponemos el nombre inicial
      	chooser.setInitialFileName("archivo.json");
      	// Obtiene el Stage principal del controlador
        Stage stage = (Stage) btnJsonPro.getScene().getWindow(); 
        //se muestra el chooser y la ruta obtenida se guarda el file
        File file = chooser.showSaveDialog(stage);
        //validamos
      	if (file != null) {
      		try{
      			//se utiliza para escribir datos en el file que recibe
      			FileWriter archivoJSON = new FileWriter(file);
      			//se crea un objeto que convierte objetos Java en JSON y viceversa
      			ObjectMapper objectMapper = new ObjectMapper();
      			//escribe en json en el archivo
      			objectMapper.writeValue(archivoJSON, data);
      			archivoJSON.close();
      			
      		    abrirFile(file.toString());//este metodo abrira el archivo
      		} catch (IOException e) {
      			e.printStackTrace();
      		}
      	}
	}
	
	//metodo para filtrar
	public void busquedaDatos() {
		//un filteredlist se utiliza para filtrar elementos de una lista observable
		FilteredList<Proveedor> datos = new FilteredList<>(listaObservable, p -> true);//los parametros son la lista de datos y el otro que se pone para indicar que al inicio se mostrara todos los elementos sin ningun filtro
		//se agrega un listener a la caja, significa que cada vez que se escriba o borre algo de la caja, el metodo se ejecutara
		busquedaPro.textProperty().addListener((observable, oldValue, newValue) -> {
			//este setpredicate, es para configurar el filtro, en este caso cada vez que haya un cambio en la caja, lo vuelve a evaluar
			datos.setPredicate(proveedor -> {
				//verifica que el nuevo valor no sea nulo
                if (newValue == null || newValue.isEmpty()) {
                    return true; //muestra todos los datos cuando no hay texto en el TextField
                }
                //convierte todo a minusculas para una busqueda sin distincion entre mayusculas y minusculas
                String lowerCaseFilter = newValue.toLowerCase();
                //compara el valor del TextField con el nombre del proveedor, si coincide devuelve true, lo que significa que se mostrara en la tabla
                return proveedor.getNombre().toLowerCase().contains(lowerCaseFilter);
            });
        });
		//mostramos la tabla con los filtros
		tblProveedores.setItems(datos);
	}
	
//  Funcion para abrir el excel una vez lo hayamos guardado
  public void abrirFile(String file) {
      try {
          File ruta = new File(file);
//          Esta clase permite abrir e imprimir ficheros
          Desktop.getDesktop().open(ruta);
      } catch (IOException e) {
          System.out.println(e);
      }

  }

}



