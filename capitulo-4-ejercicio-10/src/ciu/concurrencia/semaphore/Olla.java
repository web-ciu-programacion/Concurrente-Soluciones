package ciu.concurrencia.semaphore;

public class Olla {

	private final static int CANTIDAD = 3;

	private static int chuletas = CANTIDAD;

	public static void llenar() {
		chuletas = CANTIDAD;
	}

	public static boolean vacia() {
		return chuletas==0;
	}

	public static void agarrarChuleta() {
		chuletas--;
System.out.println(chuletas);
	}

}
