package ciu.concurrencia.semaphore;

import java.util.concurrent.Semaphore;

public class B implements Runnable {

	private Semaphore semaphore;

	public B(Semaphore s) {
		super();
		this.semaphore = s;
	}

	@Override
	public void run() {
		System.out.println("hola");
		this.semaphore.release();
	}

}
