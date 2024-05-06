package ciu.concurrencia.monitor;

/*
 * Monitor con primitivas
 */
public class MonitorA {

	private Integer cantidad;

	public MonitorA() {
		super();
		this.cantidad = 0;
	}
	
	public synchronized void entrada() {
		try {
			if (this.cantidad<2) {
				this.cantidad++;
				this.wait();
			} else {
				this.cantidad = 0;
				this.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
