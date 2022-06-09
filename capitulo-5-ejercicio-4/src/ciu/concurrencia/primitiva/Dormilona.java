package ciu.concurrencia.primitiva;

public class Dormilona extends Thread {

	private Auxiliar auxiliar;

	public Dormilona(Auxiliar auxiliar) {
		super("dormilona");
		this.auxiliar = auxiliar;
	}

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() +  " durmiendo...");
		this.auxiliar.dormir();
		System.out.println(t.getName() +  " despertada :(");
	}

}
