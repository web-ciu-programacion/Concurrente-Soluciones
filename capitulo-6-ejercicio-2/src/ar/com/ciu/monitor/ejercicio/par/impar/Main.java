package ar.com.ciu.monitor.ejercicio.par.impar;

public class Main {

	public static void main(String[] args) {
		Monitor monitor = new Monitor();
		Thread t1 = new HiloNumero("hilo 1", monitor);
		Thread t2 = new HiloNumero("hilo 2", monitor);
		Thread t3 = new HiloNumero("hilo 3", monitor);
		Thread t4 = new HiloNumero("hilo 4", monitor);
		Thread t5 = new HiloNumero("hilo 5", monitor);
		Thread t6 = new HiloNumero("hilo 6", monitor);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}

}
