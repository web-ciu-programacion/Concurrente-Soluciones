package ciu.concurrencia.semaphore;

public class Cocinero implements Runnable {

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("cocinero esperando...");
				Shared.cocinero.acquire();
				System.out.println(Thread.currentThread().getName() + " llena olla");
				Olla.llenar();
				Shared.espera.release();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
