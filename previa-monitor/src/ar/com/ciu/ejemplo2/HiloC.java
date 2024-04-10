package ar.com.ciu.ejemplo2;

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
