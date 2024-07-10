package ar.com.ciu.parcial.monitor;

public class Abastecedor implements Runnable {

	private Monitor monitor;
	private int cantidad;
	
	public Abastecedor(Monitor monitor, int cantidad) {
		this.monitor = monitor;
		this.cantidad = cantidad;
	}

	@Override
	public void run() {
		this.monitor.abastecer(this.cantidad);
	}

}
