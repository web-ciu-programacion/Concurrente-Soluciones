package ciu.concurrencia.practica;

public class HiloAutonomo implements Runnable {

	private Thread hilo;

	public HiloAutonomo(String nombre) {
		super();
		this.hilo = new Thread(this, nombre);
		this.hilo.start();
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}

}
