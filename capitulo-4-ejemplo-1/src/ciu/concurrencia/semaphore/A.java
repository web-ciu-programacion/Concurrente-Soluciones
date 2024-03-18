package ciu.concurrencia.semaphore;

import java.util.concurrent.Semaphore;

public class A implements Runnable {

	private Semaphore s1;

	public A(Semaphore s) {
		super();
		this.s1 = s;
	}

	@Override
	public void run() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName() + ": paso 0");
			System.out.println(t.getName() + " - acquired " + this.s1.availablePermits());
			this.s1.acquire();
			System.out.println(t.getName() + " - acquired " + this.s1.availablePermits());
			System.out.println("paso 1");
			this.s1.acquire(); // -->> se cuelga el proceso a la espera de un release
			System.out.println("paso 2");
			this.s1.release();
			System.out.println(t.getName() + " - acquired " + this.s1.availablePermits());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
