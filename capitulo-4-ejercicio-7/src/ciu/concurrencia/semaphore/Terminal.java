package ciu.concurrencia.semaphore;

public class Terminal implements Runnable {

	@Override
	public void run() {
		int k = 0;
		try {
			// resto instrucciones
			Shared.impresoras.acquire(); // si hay una impresora libre pasa este wait
			Shared.mutex.acquire();
			k = 0;
			while (!Shared.libre[k]) { // como paso el semaforo impresoras una posicion libre en el array habra
				k++;
			}
			Shared.libre[k] = false;
			System.out.println("[" + Shared.libre[0] + ", " + Shared.libre[1] + ", " + Shared.libre[2] + "] -> " + Thread.currentThread().getName() + " tomo impresora");
			Shared.mutex.release();
			//
			// usar impresora
			System.out.println(Thread.currentThread().getName() + " imprimiendo");
			System.out.println("[" + Shared.libre[0] + ", " + Shared.libre[1] + ", " + Shared.libre[2] + "]");
			//
			Shared.mutex.acquire();
			Shared.libre[k] = true; // una vez que uso la impresora la pongo como libre en el array
			System.out.println("[" + Shared.libre[0] + ", " + Shared.libre[1] + ", " + Shared.libre[2] + "] -> " + Thread.currentThread().getName() + " liberando...");
			Shared.mutex.release();
			Shared.impresoras.release(); // incremento el numero de impresoras libres
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
