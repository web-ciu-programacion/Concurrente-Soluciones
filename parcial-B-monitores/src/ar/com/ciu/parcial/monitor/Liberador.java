package ar.com.ciu.parcial.monitor;

public class Liberador implements Runnable {

	private Monitor monitor;
	private String causa;

	public Liberador(Monitor monitor, String causa) {
		super();
		this.monitor = monitor;
		this.causa = causa;
	}

	@Override
	public void run() {
		this.monitor.liberarInfractores(this.causa);
	}

}
