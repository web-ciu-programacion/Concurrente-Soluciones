package ciu.concurrencia.semaphore;

import java.util.concurrent.Semaphore;

public class B implements Runnable {

	private Semaphore s1;

	public B(Semaphore s) {
		super();
		this.s1 = s;
	}

	@Override
	public void run() {
		try {
			System.out.println("paso c");
			this.s1.acquire();
			System.out.println("paso d");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
