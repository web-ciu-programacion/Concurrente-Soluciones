package pro.cons.buff.limitado;

import java.io.Serializable;

public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descripcion;
	private Integer cantidad;

	public Item(String d) {
		super();
		this.descripcion = d;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
