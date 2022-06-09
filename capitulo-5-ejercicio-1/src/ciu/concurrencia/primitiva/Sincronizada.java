package ciu.concurrencia.primitiva;

public class Sincronizada  {


	public synchronized void espera() {
		try {
			System.out.println(Thread.currentThread().getName() + ": inicio espera");
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + ": fin espera");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void verSincronizado() {
		System.out.println(Thread.currentThread().getName() + ": ver sincronizado!!!");
	}

	public void verNoSincronizado() {
		System.out.println(Thread.currentThread().getName() + ": ver no sincronizado!!!");
	}

}
