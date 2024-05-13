package ciu.concurrencia.cerveceria;

public class EstanteVasosVacios extends Estante {

	public EstanteVasosVacios(int capacidad, Monitor monitor) {
		super(capacidad, monitor);
	}

	@Override
	public boolean esDeVasosLlenos() {
		return false;
	}

	@Override
	public String toString() {
		return "Estante de vasos vacios, cantidad de vasos: " + this.cantidaddeVasos();
	}
}