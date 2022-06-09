package ciu.concurrencia.semaphore;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Semaphore s1 = new Semaphore(0);
		Semaphore s2 = new Semaphore(0);
		Thread hiloA = new Thread(new A(s1, s2));
		Thread hiloB = new Thread(new B(s1, s2));
		System.out.println("inicio");
		hiloA.start();
		hiloB.start();
		System.out.println("fin");
	}

}
