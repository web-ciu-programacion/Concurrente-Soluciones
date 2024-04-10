package ar.com.ciu.ejemplo3;

public class HiloB extends Thread {

	private Pera pera;

	public HiloB(Pera s) {
		super("HiloB");
		this.pera = s;
	}

	@Override
	public void run() {
		try {
			System.out.println("hilo: " + Thread.currentThread().getName() + " previa unlock");
			Thread.sleep(3000);
			this.pera.unlock();
			System.out.println("hilo: " + Thread.currentThread().getName() + " post unlock");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
