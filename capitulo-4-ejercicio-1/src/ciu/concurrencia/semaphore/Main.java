package ciu.concurrencia.semaphore;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Semaphore s = new Semaphore(0);
		Thread hiloA = new Thread(new A(s));
		Thread hiloB = new Thread(new B(s));
		System.out.println("inicio");
		hiloA.start();
		hiloB.start();
		System.out.println("fin");
	}

}
