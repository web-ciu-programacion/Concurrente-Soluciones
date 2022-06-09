package ciu.concurrencia.semaphore;

public class Main {

	public static void main(String[] args) {
		Cocinero c = new Cocinero();
		Thread tc = new Thread(c, "cocinero");
		Thread ts1 = new Thread(new Salvaje(), "salvaje 1");
		Thread ts2 = new Thread(new Salvaje(), "salvaje 2");
		Thread ts3 = new Thread(new Salvaje(), "salvaje 3");
		Thread ts4 = new Thread(new Salvaje(), "salvaje 4");
		Thread ts5 = new Thread(new Salvaje(), "salvaje 5");
		Thread ts6 = new Thread(new Salvaje(), "salvaje 6");
		tc.start();
		ts1.start();
		ts2.start();
		ts3.start();
		ts4.start();
		ts5.start();
		ts6.start();
	}

}
