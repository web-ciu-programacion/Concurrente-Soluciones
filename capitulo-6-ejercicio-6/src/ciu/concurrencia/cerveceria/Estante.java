package ciu.concurrencia.cerveceria;

import java.util.ArrayList;
import java.util.List;

public abstract class Estante {
	
	protected List<Vaso> vasos;
	private Monitor monitor;
	private Integer capacidad;
	
	public Estante(int capacidad, Monitor monitor) {
		this.vasos = new ArrayList<Vaso>();
		this.monitor = monitor;
		this.capacidad = capacidad;
	}
	
	public abstract boolean esDeVasosLlenos();

	public void poner(Vaso vaso) {
		this.monitor.ponerVaso(vaso, this);
	}
	
	public Vaso agarrar() {
		return this.monitor.quitarVaso(this);
	}
	
	public Vaso obtenerPrimerVaso() {
		Vaso vaso = this.vasos.get(0);
		this.vasos.remove(0);
		return vaso;
	}
	
	protected int cantidaddeVasos() {
		return this.vasos.size();
	}
	
	protected boolean hayVaso() {
		return this.cantidaddeVasos()>0;
	}

	protected boolean hayLugar() {
		return this.cantidaddeVasos()<this.capacidad;
	}

	public List<Vaso> getVasos() {
		return vasos;
	}
	
}
