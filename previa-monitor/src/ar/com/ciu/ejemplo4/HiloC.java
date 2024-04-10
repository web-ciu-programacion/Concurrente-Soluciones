package ar.com.ciu.ejemplo4;

public class HiloC extends Thread {

	private AuxiliarDos auxiliar;

	public HiloC(AuxiliarDos aux) {
		super("hilo-C");
		this.auxiliar = aux;
	}

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + " esperando por un notify...");
		this.auxiliar.esperar();
		System.out.println(t.getName() + " libre al fin!!!");
	}

}
