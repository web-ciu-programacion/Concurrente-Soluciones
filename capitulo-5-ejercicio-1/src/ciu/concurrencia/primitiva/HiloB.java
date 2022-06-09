package ciu.concurrencia.primitiva;

public class HiloB extends Thread {

	private Sincronizada sincronizada;

	public HiloB(Sincronizada s) {
		super();
		this.sincronizada = s;
	}

	@Override
	public void run() {
		this.sincronizada.verNoSincronizado();
	}

}
