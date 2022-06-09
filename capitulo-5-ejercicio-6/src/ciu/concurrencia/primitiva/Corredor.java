package ciu.concurrencia.primitiva;

public class Corredor implements Runnable {

	private Banderillero banderillero;

	public Corredor(Banderillero banderillero) {
		super();
		this.banderillero = banderillero;
	}

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + " esperando largada...");
		this.banderillero.esperar();
		System.out.println(t.getName() + " corriendo como loco!!!");
	}

}
