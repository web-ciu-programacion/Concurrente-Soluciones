package ar.com.concurrencia.prioridad.lectores;

import java.util.concurrent.Semaphore;

public class Escritor extends Thread {

	private Semaphore wrt;

	public Escritor(String nombre, Semaphore wrt) {
		super(nombre);
		this.wrt = wrt;	
	}

	public void escribir() {
		try {
			this.wrt.acquire();
			Thread t = Thread.currentThread();
			// inicio bloque escritura recurso
			System.out.println(t.getName() + ": escribiendo");
			Compartida.recursoCompartido = "estado " + t.getName();
			// fin bloque escritura recurso
			this.wrt.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.escribir();
	}

}
