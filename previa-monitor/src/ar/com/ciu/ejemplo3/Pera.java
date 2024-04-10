package ar.com.ciu.ejemplo3;

public class Pera  {

	public synchronized void lock() {
		try {
			System.out.println("hilo: " + Thread.currentThread().getName() + " Bloqueado");
			this.wait();
			System.out.println("hilo: " + Thread.currentThread().getName() + " Desbloqueado");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void unlock() {
		this.notify();
		System.out.println("DesBloquear hilo (A)");
	}

}
