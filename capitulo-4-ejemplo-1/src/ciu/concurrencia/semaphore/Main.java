package ciu.concurrencia.semaphore;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Semaphore s = new Semaphore(1);
		Thread hiloA = new Thread(new A(s), "A");
		System.out.println(Thread.currentThread().getName() + ": inicio");
		hiloA.start();
		System.out.println(Thread.currentThread().getName() + ": fin");
	}

}
