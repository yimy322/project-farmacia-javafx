package models.entity;

import java.util.Date;

public class Producto {

	private String nombre;
	
	private double precio;
	
	private int stock;
	
	private Date fechaV;
	
	private Proveedor proveedor;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getFechaV() {
		return fechaV;
	}

	public void setFechaV(Date fechaV) {
		this.fechaV = fechaV;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
}
