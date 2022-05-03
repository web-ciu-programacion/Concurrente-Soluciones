package ar.com.ciu;

import java.util.concurrent.Semaphore;

public class Productor implements Runnable {

	private String palabra;
	private Semaphore mutex;
	private Semaphore vacios;
	private Semaphore llenos;

	public Productor(String palabra, Semaphore mutex, Semaphore vacios, Semaphore llenos) {
		super();
		this.palabra = palabra;
		this.mutex = mutex;
		this.vacios = vacios;
		this.llenos = llenos;
	}

	private void producir() {
		Item item = new Item(this.palabra);
		try {
			this.vacios.acquire(); // wait
			this.mutex.acquire();
			// inicio zona critica
			Compartida.buffer[Compartida.frente] = item;
			System.out.println(" + " + Thread.currentThread().getName() + " buffer[" + Compartida.frente + "] = " + this.palabra);
			Compartida.frente = (Compartida.frente+1) % Compartida.TAMANIO_BUFFER;
			// fin zona critica
			this.mutex.release();
			this.llenos.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.producir();
	}

}
