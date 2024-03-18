package ciu.concurrencia.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 
 * Demuestra que un hilo queda en WAITING cuando es bloqueado por un acquire.
 * 
 */
public class Main {

	public static void main(String[] args) {
		Semaphore s = new Semaphore(0);
		Thread a = new Thread(new A(s));
		a.start();

		while (!"TERMINATED".equals(a.getState().name())) {
			System.out.println(a.getState().name());
		}

	}

}
