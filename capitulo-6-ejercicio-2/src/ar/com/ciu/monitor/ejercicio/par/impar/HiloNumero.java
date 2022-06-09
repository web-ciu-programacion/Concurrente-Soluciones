package ar.com.ciu.monitor.ejercicio.par.impar;

public class HiloNumero extends Thread {

	private Monitor monitor;

	public HiloNumero(String n, Monitor m) {
		super(n);
		this.monitor = m;
	}

	@Override
	public void run() {
		int numero = this.generaNumero();
		System.out.println(Thread.currentThread().getName() + " genero número: " + numero);
		this.monitor.accion(numero);
		System.out.println(Thread.currentThread().getName() + " liberado!");
	}

	private int generaNumero() {
		int numero = (int)(Math.random() * 10) + 1;
		return numero;
	}

}
