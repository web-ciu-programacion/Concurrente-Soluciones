package ar.com.ciu.monitor.bolitas;

public class Main {

	public static void main(String[] args) {
		Frasco frasco = new Frasco();
		Thread j1 = new Jugador(frasco, "Pepe", 10);
		Thread j2 = new Jugador(frasco, "Ana", -5);
		Thread j3 = new Jugador(frasco, "Guada", -4);
		Thread j4 = new Jugador(frasco, "Jose", -3);
		Thread j5 = new Jugador(frasco, "Lucrecia", -5);
		Thread j6 = new Jugador(frasco, "Pipi", 4);
		Thread j7 = new Jugador(frasco, "Enzo", 1);
		j1.start();
		j2.start();
		j3.start();
		j4.start();
		j5.start();
		j6.start();
		j7.start();
	}

}
