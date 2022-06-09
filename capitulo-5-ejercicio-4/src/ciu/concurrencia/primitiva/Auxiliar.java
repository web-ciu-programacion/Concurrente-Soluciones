package ciu.concurrencia.primitiva;

public class Auxiliar {

	public synchronized void dormir() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void despertar() {
		this.notify();
	}

}
