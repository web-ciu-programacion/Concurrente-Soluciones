package ciu.concurrencia.primitiva;

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
