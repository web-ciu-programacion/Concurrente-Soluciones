package ar.com.concurrencia.prioridad.lectores;

import java.util.concurrent.Semaphore;

public class Lector extends Thread {

	private Semaphore mutex;
	private Semaphore wrt;

	public Lector(String nombre, Semaphore mutex, Semaphore wrt) {
		super(nombre);
		this.mutex = mutex;
		this.wrt = wrt;	
	}

	public void leer() {
		try {
			this.mutex.acquire();
			Compartida.nl += 1;
			if (Compartida.nl==1) {
				this.wrt.acquire();
			}
			this.mutex.release();
			// inicio bloque lectura recurso
			System.out.println(Thread.currentThread().getName() + ": leyendo -->>" + Compartida.recursoCompartido);
			// fin bloque lectura recurso
			this.mutex.acquire();
			Compartida.nl -= 1;
			if (Compartida.nl==0) {
				this.wrt.release();
			}
			this.mutex.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.leer();
	}

}
