package ar.com.ciu;

public class MonitorA {

	public synchronized void bloquea() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void desbloquea() {
		notifyAll();
	}

}
