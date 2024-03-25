package ciu.concurrencia.practica.sinhilos;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private String nombre;
	private List<Producto> productos;
	
	public Cliente(String nombre) {
		super();
		this.nombre = nombre;
		this.productos = new ArrayList<Producto>();
	}
	
	public void agregar(Producto unProducto) {
		this.productos.add(unProducto);
	}

	public String getNombre() {
		return nombre;
	}

	public List<Producto> getProductos() {
		return productos;
	}
	
}
