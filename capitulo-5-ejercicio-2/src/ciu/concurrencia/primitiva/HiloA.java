package ciu.concurrencia.primitiva;

public class HiloA extends Thread {

	private Dado dado;

	public HiloA(Dado s) {
		super();
		this.dado = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": " + this.dado.darNumero());
	}

}
