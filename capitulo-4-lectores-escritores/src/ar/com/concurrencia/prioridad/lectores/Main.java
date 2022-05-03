package ar.com.concurrencia.prioridad.lectores;

import java.util.concurrent.Semaphore;

/*
 * Prioridad Lectores
 */
public class Main {

	public static void main(String[] args) {
		Semaphore mutex = new Semaphore(1, true);
		Semaphore wrt = new Semaphore(1, true);
		Thread l1 = new Lector("lector 1", mutex, wrt);
		Thread l2 = new Lector("lector 2", mutex, wrt);
		Thread l3 = new Lector("lector 3", mutex, wrt);
		Thread l4 = new Lector("lector 4", mutex, wrt);
		Thread l5 = new Lector("lector 5", mutex, wrt);
		Thread l6 = new Lector("lector 6", mutex, wrt);
		Thread l7 = new Lector("lector 7", mutex, wrt);
		Thread e1 = new Escritor("escritor 1", wrt);
		Thread e2 = new Escritor("escritor 2", wrt);
		Thread e3 = new Escritor("escritor 3", wrt);
		Thread e4 = new Escritor("escritor 4", wrt);
		Thread e5 = new Escritor("escritor 5", wrt);
		Thread e6 = new Escritor("escritor 6", wrt);
		l1.start();
		l2.start();
		l3.start();
		l4.start();
		l5.start();
		e1.start();
		e2.start();
		e3.start();
		e4.start();
		e5.start();
		e6.start();
		l6.start();
		l7.start();
	}

}
