package ar.com.ciu;

import java.util.concurrent.Semaphore;

/*
 * 
 * Problema clásico de Productores y Consumidores con buffer limitado.
 * Resolución con semáforos.
 * 
 */
public class Main {

	public static void main(String[] args) {

		Semaphore mutex = new Semaphore(1);
		Semaphore vacios = new Semaphore(Compartida.TAMANIO_BUFFER, true);
		Semaphore llenos = new Semaphore(0, true);

		Thread p1 = new Thread(new Productor("Lamadrid", mutex, vacios, llenos), "Productor-1");
		Thread p2 = new Thread(new Productor("el", mutex, vacios, llenos), "Productor-2");
		Thread p3 = new Thread(new Productor("mas", mutex, vacios, llenos), "Productor-3");
		Thread p4 = new Thread(new Productor("grande", mutex, vacios, llenos), "Productor-4");
		Thread p5 = new Thread(new Productor("lejos", mutex, vacios, llenos), "Productor-5");
		// Puedo seguir poniedo productores...(si el buffer está lleno se bloquea el hilo)
		//Thread p6 = new Thread(new Productor("!!", mutex, vacios, llenos), "Productor-6");
		//Thread p7 = new Thread(new Productor("##", mutex, vacios, llenos), "Productor-7");

		Thread c1 = new Thread(new Consumidor(mutex, vacios, llenos), "Consumidor-1");
		Thread c2 = new Thread(new Consumidor(mutex, vacios, llenos), "Consumidor-2");
		Thread c3 = new Thread(new Consumidor(mutex, vacios, llenos), "Consumidor-3");
		Thread c4 = new Thread(new Consumidor(mutex, vacios, llenos), "Consumidor-4");
		Thread c5 = new Thread(new Consumidor(mutex, vacios, llenos), "Consumidor-5");
		// Puedo seguir poniedo consumidores...(si el buffer está vacío se bloquea el hilo)
		Thread c6 = new Thread(new Consumidor(mutex, vacios, llenos), "Consumidor-6");
		//Thread c7 = new Thread(new Consumidor(mutex, vacios, llenos), "Consumidor-7");
//		Thread cExtra = new Thread(new Consumidor(mutex, vacios, llenos), "Consumidor-Extra");

		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		//p6.start();
		//p7.start();
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		c6.start();
		//c7.start();
		//cExtra.start();

	}

}
