package ciu.concurrencia.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 
 * Muestra por consola:
 *   hola
 *   chau
 * SIEMPRE en ese orden.
 * 
 */
public class Main {

	public static void main(String[] args) {
		Semaphore s = new Semaphore(0);
		Thread a = new Thread(new A(s));
		Thread b = new Thread(new B(s));
		b.start();
		a.start();

		while (a.isAlive() || b.isAlive()) {
			continue;
		}

		System.out.println("permits: " + s.drainPermits());

	}

}
