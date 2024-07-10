package ar.com.ciu.recuperatorio.monitor;

public class Creyente implements Runnable {

	private Monitor monitor;
	private int numeroDeConfesionario;
	
	public Creyente(Monitor monitor, int numeroDeConfesionario) {
		this.monitor = monitor;
		this.numeroDeConfesionario = numeroDeConfesionario;
	}
	
	@Override
	public void run() {
		this.monitor.entrarAConfesionario(this.numeroDeConfesionario);
		System.out.println(Thread.currentThread().getName() + " se está confesando en confesionario: " + this.numeroDeConfesionario);
		this.monitor.abandonarConfesionario(numeroDeConfesionario);
	}

}
