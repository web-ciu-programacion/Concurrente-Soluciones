package ciu.concurrente.monitor.lecesc.escritor;

import ciu.concurrente.monitor.lecesc.monitor.Sincronizador;

public class Escritor implements Runnable {

	public Sincronizador sincronizador;
	
	public Escritor(Sincronizador sincronizador) {
		this.sincronizador = sincronizador;
	}
	
	@Override
	public void run() {
		this.sincronizador.abrirEscritura();
		System.out.println("Escritor: " + Thread.currentThread().getName() + " escribiendo...");
		this.sincronizador.cerrarEscritura();;
	}

}
