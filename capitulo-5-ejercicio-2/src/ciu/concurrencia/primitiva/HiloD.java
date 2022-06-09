package ciu.concurrencia.primitiva;

public class HiloD extends Thread {

	private Dado dado;

	public HiloD(Dado s) {
		super();
		this.dado = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": " + this.dado.darNumero());
	}

}
