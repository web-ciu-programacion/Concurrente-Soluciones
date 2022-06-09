package ciu.concurrencia.primitiva;

public class Main {

	/*
	 *  Sirve para entender que al utilizar wait y notify es necesario que esté en 
	 *  un bloque synchronized
	 */
	public static void main(String[] args) {
		Auxiliar aux = new Auxiliar();
		Thread ha = new Paciente("Camila", aux);
		Thread hb = new Paciente("Gerardo", aux);
		Thread doc = new Doctor(aux);
		ha.start();
		hb.start();
		doc.start();
	}

}
