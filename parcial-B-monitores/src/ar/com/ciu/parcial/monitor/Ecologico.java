package ar.com.ciu.parcial.monitor;

public class Ecologico extends Infractor {

	protected Ecologico(Monitor monitor) {
		super(monitor);
	}

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + " cometio infraccion: " + this.getInfraccionCometida());
		this.monitor.retenerInfractor(this);
		System.out.println(t.getName() + " libre al fin!");
	}

	@Override
	public String getInfraccionCometida() {
		return ECOLOGICA;
	}

}
