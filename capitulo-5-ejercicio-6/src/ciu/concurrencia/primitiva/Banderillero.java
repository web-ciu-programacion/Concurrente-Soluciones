package ciu.concurrencia.primitiva;

public class Banderillero {

	private int cantidadDeCorredores;

	public Banderillero(int cantidadDeCorredores) {
		super();
		this.cantidadDeCorredores = cantidadDeCorredores;
	}

	public synchronized void esperar() {
		try {
			this.cantidadDeCorredores--;
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void largar() {
		System.out.println("largaron...");
		this.notifyAll();
	}

	public boolean isCorredoresListos() {
		return this.cantidadDeCorredores<1;
	}
	
	public int getCantidadDeCorredores() {
		return cantidadDeCorredores;
	}

}
