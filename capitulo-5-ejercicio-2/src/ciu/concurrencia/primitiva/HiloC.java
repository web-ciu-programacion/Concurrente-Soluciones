package ciu.concurrencia.primitiva;

public class HiloC extends Thread {

	private Dado dado;

	public HiloC(Dado s) {
		super();
		this.dado = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": " + this.dado.darNumero());
	}

}
