package ciu.concurrencia.practica;

public class Main {

	/*
	 * Respuesta: Por que el hilo vigilante comenzó a vigilarlo una vez que el 
	 * vigilado ya cambió de estado, eso lo maneja el S.O.. 
	 */
	public static void main(String[] args) {
		Thread vigilado = new Thread(new Vigilado(), "vigilado");
		Thread vigilante = new Thread(new Vigilante(vigilado));
		vigilante.start();
		vigilado.start();
	}

}
