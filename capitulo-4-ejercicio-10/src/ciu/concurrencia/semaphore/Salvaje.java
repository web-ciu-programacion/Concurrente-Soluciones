package ciu.concurrencia.semaphore;

public class Salvaje implements Runnable {

	public Salvaje() {
		super();
	}

	@Override
	public void run() {
		try {
			Shared.mutex.acquire();
			if (Olla.vacia()) {
				System.out.println(Thread.currentThread().getName() + " llama a cocinero");
				Shared.cocinero.release();
				System.out.println(Thread.currentThread().getName() + " espera");
				Shared.espera.acquire();
			}
			Olla.agarrarChuleta();
			System.out.println(Thread.currentThread().getName() + " agarro chuleta");
			Shared.mutex.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
