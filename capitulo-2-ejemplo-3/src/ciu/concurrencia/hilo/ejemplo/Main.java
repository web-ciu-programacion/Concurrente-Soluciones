package ciu.concurrencia.hilo.ejemplo;

public class Main {

	public static void main(String[] args) {
		System.out.println("inicio " + Thread.currentThread().getName());
		Thread t = new PrimerHilo();
		
		Thread t2 = new Thread(new SegundoHilo(), "Capo");
		t2.start();
		
		t.start();
		System.out.println("fin " + Thread.currentThread().getName());
	}

}
