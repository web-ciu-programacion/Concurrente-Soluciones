package ar.com.ciu.monitor.bolitas;

public class Jugador extends Thread {

	private Frasco frasco;
	private int cantidadDeBolitas;

	public Jugador(Frasco f, String nombre, int cantidad) {
		super(nombre);
		this.frasco = f;
		this.cantidadDeBolitas = cantidad;
	}

	@Override
	public void run() {
		if (this.cantidadDeBolitas<0) {
			this.frasco.sacar(this.cantidadDeBolitas*-1);
		} else {
			this.frasco.poner(this.cantidadDeBolitas);
		}
	}

}
