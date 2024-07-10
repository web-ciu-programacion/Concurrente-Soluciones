package ar.com.ciu.recuperatorio.monitor;

public class Main {

	public static void main(String[] args) {
		Monitor monitor = new Monitor();
		Thread creyente1 = new Thread(new Creyente(monitor, 0), "creyente 1");
		Thread creyente2 = new Thread(new Creyente(monitor, 1), "creyente 2");
		Thread creyente3 = new Thread(new Creyente(monitor, 0), "creyente 3");
		Thread creyente4 = new Thread(new Creyente(monitor, 1), "creyente 4");
		Thread creyente5 = new Thread(new Creyente(monitor, 0), "creyente 5");
		creyente1.start();
		creyente2.start();
		creyente3.start();
		creyente4.start();
		creyente5.start();
	}

}
