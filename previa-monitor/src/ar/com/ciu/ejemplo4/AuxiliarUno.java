package ar.com.ciu.ejemplo4;

public class AuxiliarUno {

	public synchronized void esperar() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void liberar() {
		this.notify();
	}

	public synchronized void liberarTodos() {
		this.notifyAll();
	}

}
