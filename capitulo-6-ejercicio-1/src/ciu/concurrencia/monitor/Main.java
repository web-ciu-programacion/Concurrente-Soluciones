package ciu.concurrencia.monitor;

public class Main {

	public static void main(String[] args) {
		MonitorA monitor = new MonitorA();
		Thread hiloA = new Hilo(monitor);
		Thread hiloB = new Hilo(monitor);
		Thread hiloC = new Hilo(monitor);
		hiloA.start();
		hiloB.start();
		hiloC.start();
	}

}
