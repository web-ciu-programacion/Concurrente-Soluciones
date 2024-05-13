package ciu.concurrencia.cerveceria;

public class EstanteVasosLlenos extends Estante {

	public EstanteVasosLlenos(int capacidad, Monitor monitor) {
		super(capacidad, monitor);
	}

	@Override
	public boolean esDeVasosLlenos() {
		return true;
	}

	@Override
	public String toString() {
		return "Estante de vasos llenos, cantidad de vasos: " + this.cantidaddeVasos();
	}
}