package ciu.concurrencia.monitor;

public class Hilo extends Thread {

	private MonitorA monitor;

	public Hilo(MonitorA monitor) {
		super();
		this.monitor = monitor;
	}

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + " Previa");
		this.monitor.entrada();
		System.out.println(t.getName() + " Fin");
	}

}
