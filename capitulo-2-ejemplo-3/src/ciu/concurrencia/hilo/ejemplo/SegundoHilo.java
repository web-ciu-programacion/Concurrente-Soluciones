package ciu.concurrencia.hilo.ejemplo;

public class SegundoHilo implements Runnable {

	@Override
	public void run() {
		System.out.println("hola desde hilo..." + Thread.currentThread().getName());
	}

}
