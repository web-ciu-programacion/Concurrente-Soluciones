package ar.com.ciu.ejemplo1;

public class HiloB extends Thread {

	private Sincronizada sincronizada;

	public HiloB(Sincronizada s) {
		super();
		this.sincronizada = s;
	}

	@Override
	public void run() {
		this.sincronizada.deAUnoPorFavor();
	}

}
