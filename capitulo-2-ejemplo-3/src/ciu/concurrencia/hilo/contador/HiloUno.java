package ciu.concurrencia.hilo.contador;

public class HiloUno implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 20000; i++) {
			Compartida.incrementar();
		}
		System.out.println("fin hilo: " + Thread.currentThread().getName());
		System.out.println("valor i: " + Compartida.getContador());
	}

}
