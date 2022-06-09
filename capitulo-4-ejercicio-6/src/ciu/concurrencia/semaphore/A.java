package ciu.concurrencia.semaphore;

import java.util.concurrent.Semaphore;

public class A implements Runnable {

	private Semaphore s1;

	public A(Semaphore s1) {
		super();
		this.s1 = s1;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " bloqueado.");
		try {
			this.s1.acquire();
			System.out.println(Thread.currentThread().getName() + " DESbloqueado.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
