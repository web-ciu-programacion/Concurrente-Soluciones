package ar.com.ciu;

import java.util.concurrent.Semaphore;

public class Consumidor implements Runnable {

	private Semaphore mutex;
	private Semaphore vacios;
	private Semaphore llenos;

	public Consumidor(Semaphore mutex, Semaphore vacios, Semaphore llenos) {
		super();
		this.mutex = mutex;
		this.vacios = vacios;
		this.llenos = llenos;
	}

	private void consumir() {
		Item item = null;
		try {
			this.llenos.acquire();
			this.mutex.acquire();
			// inicio zona critica
			item = Compartida.buffer[Compartida.cola];
			System.out.println(" - " + Thread.currentThread().getName() + " buffer[" + Compartida.cola + "] -> " + item.getPalabra());
			Compartida.cola = (Compartida.cola+1) % Compartida.TAMANIO_BUFFER;
			// fin zona critica
			this.mutex.release();
			this.vacios.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.consumir();
	}

}
