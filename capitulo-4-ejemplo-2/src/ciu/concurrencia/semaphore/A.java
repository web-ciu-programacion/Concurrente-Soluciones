package ciu.concurrencia.semaphore;

import java.util.concurrent.Semaphore;

public class A implements Runnable {

	private Semaphore semaphore;

	public A(Semaphore s) {
		super();
		this.semaphore = s;
	}

	@Override
	public void run() {
		try {
			this.semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("chau");
	}

}
