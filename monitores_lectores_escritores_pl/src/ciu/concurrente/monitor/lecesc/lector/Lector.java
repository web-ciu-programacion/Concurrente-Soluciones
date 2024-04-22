package ciu.concurrente.monitor.lecesc.lector;

import ciu.concurrente.monitor.lecesc.monitor.Sincronizador;

public class Lector implements Runnable {

	public Sincronizador sincronizador;
	
	public Lector(Sincronizador sincronizador) {
		this.sincronizador = sincronizador;
	}
	
	@Override
	public void run() {
		this.sincronizador.abrirLectura();
		System.out.println("Lector: " + Thread.currentThread().getName() + " leyendo...");
		this.sincronizador.cerrarLectura();
	}

}
