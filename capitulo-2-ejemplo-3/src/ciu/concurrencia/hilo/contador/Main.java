package ciu.concurrencia.hilo.contador;

/*
 * Demostración de que el contador finaliza en este caso un valor <= 300.
 */
public class Main {

	public static void main(String[] args) {
		Thread t1 = new Thread(new HiloUno(), "Lama");
		Thread t2 = new Thread(new HiloDos(), "Capo");
		t2.start();
		t1.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("El valor de i es: " + Compartida.getContador() + " hilo: " + Thread.currentThread().getName());
	}

}
