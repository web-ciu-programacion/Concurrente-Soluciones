package ar.com.ciu.ejemplo3;

public class Main {

	// Primer ejemplo de wait y notify.
	// El HiloA es bloqueado por el objeto: Pera
	// El HiloB luego de 3 segundos (por si este comienza primero) realiza un notify
	// mediante EL MISMO OBJETO Pera, de manera, de liberar un hilo bloqueado, HiloA en este caso
	public static void main(String[] args) {
		Pera pera = new Pera();
		Thread ha = new HiloA(pera);
		Thread hb = new HiloB(pera);
		ha.start();
		hb.start();
	}

}
