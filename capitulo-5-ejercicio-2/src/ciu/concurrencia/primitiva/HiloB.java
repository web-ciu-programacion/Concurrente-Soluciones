package ciu.concurrencia.primitiva;

public class HiloB extends Thread {

	private Dado dado;

	public HiloB(Dado s) {
		super();
		this.dado = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": " + this.dado.darNumero());
	}

}
