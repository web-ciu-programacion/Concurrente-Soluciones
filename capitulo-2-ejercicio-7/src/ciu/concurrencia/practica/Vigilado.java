package ciu.concurrencia.practica;

public class Vigilado implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(5);
			for (int i = 0; i < 100000; i++) {				
			}
			Thread.yield();
			for (int i = 0; i < 100000; i++) {				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

