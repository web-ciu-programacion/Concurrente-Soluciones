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
		System.out.println("paso a");
		this.s1.release();
		System.out.println("paso b");
	}

}
