package models.entity;

public class ItemVenta {
	
	private int cantidad;
	
	private Producto producto;

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public double calcularImporte() {
		return this.producto.getPrecio() * this.cantidad;
	}
	
}
