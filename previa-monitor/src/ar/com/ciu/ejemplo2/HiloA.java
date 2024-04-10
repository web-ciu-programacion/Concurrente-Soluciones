package ar.com.ciu.ejemplo2;

public class HiloA extends Thread {

	private Sincronizada sincronizada;

	public HiloA(Sincronizada s) {
		super();
		this.sincronizada = s;
	}

	@Override
	public void run() {
		this.sincronizada.espera();
	}

}
