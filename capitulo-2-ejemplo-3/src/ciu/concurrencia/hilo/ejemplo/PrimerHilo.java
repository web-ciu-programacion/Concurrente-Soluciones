package ciu.concurrencia.hilo.ejemplo;

public class PrimerHilo extends Thread {

	public PrimerHilo() {
		super("Lama");
	}
	
	@Override
	public void run() {
		System.out.println("hola desde hilo..." + Thread.currentThread().getName());
	}

}
