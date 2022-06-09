package ciu.concurrencia.semaphore;

import java.util.concurrent.Semaphore;

public class B implements Runnable {

	private Semaphore s1;
	private Semaphore s2;

	public B(Semaphore s1, Semaphore s2) {
		super();
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void run() {
		try {
			System.out.println("paso c");
			this.s2.release();
			this.s1.acquire();
			System.out.println("paso d");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
