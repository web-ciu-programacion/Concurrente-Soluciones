package ciu.concurrencia.practica;

public class Main {

	public static void main(String[] args) {
		Thread h1 = new Thread(new MiHilo(), "hilo 1");
		Thread h2 = new Thread(new MiHilo(), "hilo 2");
		h1.start();
		h2.start();
		System.out.println("fin main");
	}

}
