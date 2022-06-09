package ar.com.ciu;

public class SujetoB extends Thread {

	private MonitorA monitorA;
	private MonitorB monitorB;

	public SujetoB(MonitorA monitor) {
		super();
		this.monitorA = monitor;
	}

	public SujetoB(MonitorB monitor) {
		super();
		this.monitorB = monitor;
	}

	@Override
	public void run() {
		System.out.println("1 sujeto B");
		System.out.println("2 sujeto B");
		System.out.println("3 sujeto B");
		this.monitorA.desbloquea();
//		this.monitorB.desbloquea();
	}

}
