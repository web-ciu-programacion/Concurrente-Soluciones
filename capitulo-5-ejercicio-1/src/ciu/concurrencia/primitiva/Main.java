package ciu.concurrencia.primitiva;

public class Main {

	/*
	 * Mediante este ejemplo se ve que dos hilos no pueden acceder a diferentes
	 * métodos synchronized del mismo objeto al mismo tiempo, en cambio si un método
	 * no está sincronizado (en ese mismo objeto) si se ejecuta.
	 * 
	 * Nota: El ejemplo es válido si ejecuta primero el HiloA, reiterar la ejecución hasta
	 *       comience dicho hilo. 
	 * 
	 */
	public static void main(String[] args) {
		Sincronizada s = new Sincronizada();
		Thread ha = new HiloA(s);
		Thread hb = new HiloB(s);
		Thread hc = new HiloC(s);
		ha.start();
		hb.start();
		hc.start();
	}

}
