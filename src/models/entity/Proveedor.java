package models.entity;

import java.util.Arrays;

public class Proveedor{

	private int id;

	private String nombre;

	private String telefono;

	private String direccion;

	private String nacionalidad;

	public Proveedor(int id) {
		super();
		this.id = id;
	}

	public Proveedor(int id, String nombre, String telefono, String direccion, String nacionalidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.nacionalidad = nacionalidad;
	}

	public Proveedor(String nombre, String telefono, String direccion, String nacionalidad) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.nacionalidad = nacionalidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return Arrays.asList(this.id, this.nombre, this.telefono, this.direccion, this.nacionalidad).toString();
	}

}
