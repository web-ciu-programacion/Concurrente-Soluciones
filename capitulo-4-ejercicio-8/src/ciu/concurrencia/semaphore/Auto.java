package ciu.concurrencia.semaphore;

public class Auto implements Runnable {

	@Override
	public void run() {
		try {
			Shared.puente.acquire();
			System.out.println(Thread.currentThread().getName() + " cruzo el puente");
			Shared.puente.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
