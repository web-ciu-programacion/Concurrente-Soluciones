package ciu.concurrencia.cerveceria;

public class Vaso {

	private Integer numero;
	private EstadoVaso estado;
	
	public Vaso(int numero) {
		this.estado = EstadoVaso.VACIO;
		this.numero = numero;
	}
	
	public void llenar() {
		this.estado = EstadoVaso.LLENO;
	}

	public void tomar() {
		this.estado = EstadoVaso.VACIO;
	}

	public boolean estaLLeno() {
		return EstadoVaso.LLENO == this.estado;
	}

	public boolean estaVacio() {
		return EstadoVaso.VACIO == this.estado;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public EstadoVaso getEstado() {
		return estado;
	}

	public void setEstado(EstadoVaso estado) {
		this.estado = estado;
	}
}
