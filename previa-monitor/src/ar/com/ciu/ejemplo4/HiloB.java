package ar.com.ciu.ejemplo4;

public class HiloB extends Thread {

	private AuxiliarUno auxiliar;

	public HiloB(AuxiliarUno aux) {
		super("hilo-B");
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
		System.out.println(t.getName() + " libero un hilo...");
		this.auxiliar.liberar();
	}

}
