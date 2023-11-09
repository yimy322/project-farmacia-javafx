module farmaciaFx {
	requires com.fasterxml.jackson.core;
	requires org.apache.poi.ooxml;
	requires javafx.controls;
	requires javafx.base;
    requires javafx.graphics;
	requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	requires com.fasterxml.jackson.databind;
	opens controllers;
	opens models.entity;//para permitir que pueda acceder a esa carpeta
	opens application to javafx.graphics, javafx.fxml;
}
