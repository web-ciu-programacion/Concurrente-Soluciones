package ar.com.ciu.ejemplo4;

public class HiloE extends Thread {

	private AuxiliarDos auxiliar;

	public HiloE(AuxiliarDos aux) {
		super("hilo-E");
		this.auxiliar = aux;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread t = Thread.currentThread();

//		Caso 1: Libero un hilo, queda uno pendiente!
		System.out.println(t.getName() + " libero un hilo...");
		this.auxiliar.liberar();

//		Caso 2: Libero todos los hilos!
//		System.out.println(t.getName() + " libero todos los hilos!");
//		this.auxiliar.liberarTodos();
	}

}
