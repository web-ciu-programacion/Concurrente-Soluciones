package ciu.concurrencia.hilo.contador;

public class Compartida {

	private static int contador = 0;
	
	public static void incrementar() {
		contador = contador + 1;
	}
	
	public static int getContador() {
		return contador;
	}
}
