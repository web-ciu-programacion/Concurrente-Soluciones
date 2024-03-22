package cena.filosofo;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Semaphore sitio = new Semaphore(4); // Control cantidad de filosofos sentados para comer
		Semaphore[] palillo = new Semaphore[5]; // Mutex
		for (int i = 0; i < palillo.length; i++) {
			palillo[i] = new Semaphore(1);
		}
		Thread filosofo0 = new Thread(new Filosofo(0, sitio, palillo), "Sócrates");
		Thread filosofo1 = new Thread(new Filosofo(1, sitio, palillo), "Platón");
		Thread filosofo2 = new Thread(new Filosofo(2, sitio, palillo), "Aristóteles");
		Thread filosofo3 = new Thread(new Filosofo(3, sitio, palillo), "Descartes");
		Thread filosofo4 = new Thread(new Filosofo(4, sitio, palillo), "Nietzsche");
		filosofo0.start();
		filosofo1.start();
		filosofo2.start();
		filosofo3.start();
		filosofo4.start();
	}

}
