package ar.com.ciu;

public class SujetoA extends Thread {

	private MonitorA monitorA;
	private MonitorB monitorB;

	public SujetoA(MonitorA monitor) {
		super();
		this.monitorA = monitor;
	}

	public SujetoA(MonitorB monitor) {
		super();
		this.monitorB = monitor;
	}

	@Override
	public void run() {
		System.out.println("1 sujeto A");
		this.monitorA.bloquea(); // continua su ejecucion luego que lo libera SujetoB
//		this.monitorB.bloquea(); // continua su ejecucion luego que lo libera SujetoB
		System.out.println("2 sujeto A");
		System.out.println("3 sujeto A");
	}

}
