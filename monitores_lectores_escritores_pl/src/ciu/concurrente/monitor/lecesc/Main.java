package ciu.concurrente.monitor.lecesc;

import ciu.concurrente.monitor.lecesc.escritor.Escritor;
import ciu.concurrente.monitor.lecesc.lector.Lector;
import ciu.concurrente.monitor.lecesc.monitor.Sincronizador;

public class Main {

	/*
	 * Lectores / Escritores con prioridad Lectura resuelto con Monitores 
	 */
	public static void main(String[] args) {
		Sincronizador sincronizador = new Sincronizador();
		Thread lector1 = new Thread(new Lector(sincronizador), "lector 1");
		Thread lector2 = new Thread(new Lector(sincronizador), "lector 2");
		Thread lector3 = new Thread(new Lector(sincronizador), "lector 3");
		Thread lector4 = new Thread(new Lector(sincronizador), "lector 4");
		Thread lector5 = new Thread(new Lector(sincronizador), "lector 5");
		Thread escritor1 = new Thread(new Escritor(sincronizador), "escritor 1");
		Thread escritor2 = new Thread(new Escritor(sincronizador), "escritor 2");
		lector1.start();
		escritor1.start();
		lector2.start();
		lector3.start();
		escritor2.start();
		lector4.start();
		lector5.start();
	}

}
