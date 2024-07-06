package ar.com.ciu.parcial.monitor;

public abstract class Infractor implements Runnable {

	public static final String EBRIEDAD = "ebriedad";
	public static final String ECOLOGICA = "ecologica";
	public static final String TRANSITO = "transito";

	protected Monitor monitor;

	protected Infractor(Monitor monitor) {
		super();
		this.monitor = monitor;
	}

	public abstract String getInfraccionCometida();

}
