package ar.com.ciu.parcial.monitor;

public class Cliente implements Runnable {

	private Monitor monitor;
	private int cantidad;
	
	public Cliente(Monitor monitor, int cantidad) {
		this.monitor = monitor;
		this.cantidad = cantidad;
	}
	
	@Override
	public void run() {
		this.monitor.comprar(this.cantidad);
	}

}
