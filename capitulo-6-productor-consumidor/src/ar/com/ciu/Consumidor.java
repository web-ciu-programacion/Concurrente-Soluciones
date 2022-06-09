package ar.com.ciu;

public class Consumidor extends Thread {

		// atributos
	private Buffer buffer;

		// constructor
	public Consumidor(String nombre, Buffer buffer) {
		super(nombre);
		this.buffer = buffer;
	}

		// metodos
	@Override
	public void run() {
		for (int i = 0; i < 7; i++) {
			this.buffer.extraer();	
		}
	}

}
