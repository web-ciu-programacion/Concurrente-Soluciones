package ciu.previa.cap6;

public class Consumidor extends Thread {

	private Recurso recurso;

	public Consumidor(String nombre, Recurso recurso) {
		super(nombre);
		this.recurso = recurso;
	}

	@Override
	public void run() {
		try {
			this.recurso.consume();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}
