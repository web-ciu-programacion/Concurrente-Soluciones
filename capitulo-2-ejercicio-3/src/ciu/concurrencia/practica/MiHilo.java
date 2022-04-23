package ciu.concurrencia.practica;

public class MiHilo implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

}
