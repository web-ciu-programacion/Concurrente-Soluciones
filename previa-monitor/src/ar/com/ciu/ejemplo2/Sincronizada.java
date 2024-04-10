package ar.com.ciu.ejemplo2;

public class Sincronizada  {


	public synchronized void espera() {
		try {
			System.out.println(Thread.currentThread().getName() + ": Inicio espera");
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + ": Fin espera");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void verSincronizado() {
		System.out.println(Thread.currentThread().getName() + ": Ver sincronizado!!!");
	}

	public void verNoSincronizado() {
		System.out.println(Thread.currentThread().getName() + ": Ver no sincronizado!!!");
	}

}
