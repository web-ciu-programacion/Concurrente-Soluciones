package ar.com.ciu.ejemplo3;

public class HiloA extends Thread {

	private Pera pera;

	public HiloA(Pera s) {
		super("HiloA");
		this.pera = s;
	}

	@Override
	public void run() {
		System.out.println("hilo: " + Thread.currentThread().getName() + " previa lock");
		this.pera.lock();
		System.out.println("hilo: " + Thread.currentThread().getName() + " post lock");
	}

}
