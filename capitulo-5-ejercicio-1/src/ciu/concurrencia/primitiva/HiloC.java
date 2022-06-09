package ciu.concurrencia.primitiva;

public class HiloC extends Thread {

	private Sincronizada sincronizada;

	public HiloC(Sincronizada s) {
		super();
		this.sincronizada = s;
	}

	@Override
	public void run() {
		this.sincronizada.verSincronizado();
	}

}
