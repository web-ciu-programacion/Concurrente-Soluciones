package ar.com.ciu.ejemplo4;

public class HiloA extends Thread {

	private AuxiliarUno auxiliar;

	public HiloA(AuxiliarUno aux) {
		super("hilo-A");
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
