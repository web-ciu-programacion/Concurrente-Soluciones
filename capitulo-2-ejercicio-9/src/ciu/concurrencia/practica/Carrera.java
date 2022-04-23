package ciu.concurrencia.practica;

public class Carrera {

	public static void main(String[] args) {
		Thread c1 = new Thread(new Competidor(), "Carlitos");
		Thread c2 = new Thread(new Competidor(), "Pepito");
		Thread c3 = new Thread(new Competidor(), "Juancito");
		c1.start();
		c2.start();
		c3.start();
	}

}
