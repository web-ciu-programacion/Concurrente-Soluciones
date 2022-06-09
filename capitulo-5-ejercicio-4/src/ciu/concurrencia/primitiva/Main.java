package ciu.concurrencia.primitiva;

public class Main {

	/*
	 *  Sirve para entender que al utilizar wait y notify es necesario que esté en 
	 *  un bloque synchronized. También se observa que el encargado de bloquear los
	 *  hilos es el objeto Auxiliar, esdecir los hilos quedan bloqueados en el 
	 *  objeto candado Auxiliar que esel que emite el wait.
	 */
	public static void main(String[] args) {
		Auxiliar aux = new Auxiliar();
		Thread ha = new Dormilona(aux);
		Thread hb = new Hiperactiva(aux);
		ha.start();
		hb.start();
	}

}
