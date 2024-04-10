package ar.com.ciu.ejemplo4;

public class HiloD extends Thread {

	private AuxiliarDos auxiliar;

	public HiloD(AuxiliarDos aux) {
		super("hilo-D");
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
