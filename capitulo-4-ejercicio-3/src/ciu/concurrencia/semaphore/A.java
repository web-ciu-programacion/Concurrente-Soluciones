package ciu.concurrencia.semaphore;

import java.util.concurrent.Semaphore;

public class A implements Runnable {

	private Semaphore s1;
	private Semaphore s2;

	public A(Semaphore s1, Semaphore s2) {
		super();
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void run() {
		System.out.println("paso a");
		this.s1.release();
		try {
			this.s2.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("paso b");
	}

}
