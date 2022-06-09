package ciu.concurrencia.semaphore;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Semaphore s1 = new Semaphore(0, true/*false*/);
		Thread hiloA = new Thread(new A(s1), "A");
		Thread hiloB = new Thread(new A(s1), "B");
		Thread hiloC = new Thread(new A(s1), "C");
		Thread hiloD = new Thread(new A(s1), "D");
		Thread hiloE = new Thread(new A(s1), "E");
		System.out.println(Thread.currentThread().getName() + " inicio");
		try {
			hiloA.start();
			Thread.sleep(500);
			hiloB.start();
			Thread.sleep(500);
			hiloC.start();
			Thread.sleep(500);
			hiloD.start();
			Thread.sleep(500);
			hiloE.start();
			Thread.sleep(1500);
			s1.release(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " fin");
	}

}
