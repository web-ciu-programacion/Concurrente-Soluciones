package ciu.concurrencia.primitiva;

public class Auxiliar {

	public synchronized void esperar() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void atender() {
		this.notify();
	}

}
