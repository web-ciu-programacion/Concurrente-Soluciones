package ar.com.ciu.ejemplo1;

public class Sincronizada  {


	public synchronized void deAUnoPorFavor() {
		try {
			System.out.println(Thread.currentThread().getName() + ": Inicio");
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + ": Fin");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
