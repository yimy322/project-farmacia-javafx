package models.entity;

import java.util.Date;
import java.util.List;

public class Venta {

	private List<ItemVenta> itemVentas;

	private Date fechaC;

	private Usuario usuario;

	private Cliente cliente;

	private double total;

	public List<ItemVenta> getItemVentas() {
		return itemVentas;
	}

	public void setItemVentas(List<ItemVenta> itemVentas) {
		this.itemVentas = itemVentas;
	}

	public Date getFechaC() {
		return fechaC;
	}

	public void setFechaC(Date fechaC) {
		this.fechaC = fechaC;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double calculartotal() {
		double total = 0.0;

		for (int i = 0; i < itemVentas.size(); i++) {
			total += itemVentas.get(i).calcularImporte();
		}
		return total;
	}

}
