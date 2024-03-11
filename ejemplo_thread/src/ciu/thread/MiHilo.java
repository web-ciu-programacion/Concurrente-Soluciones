package ciu.thread;

public class MiHilo implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("    Aguante Lamadrid!!!" + " " + Thread.currentThread().getName() );
	}
}
