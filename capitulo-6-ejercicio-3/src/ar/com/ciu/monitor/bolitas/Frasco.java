package ar.com.ciu.monitor.bolitas;

public class Frasco {

	private int bolitas;

	public Frasco() {
		super();
		this.bolitas = 0;
	}

	public synchronized void poner(int cantidad) {
		this.bolitas += cantidad;
		System.out.println(Thread.currentThread().getName() + " puso: " + cantidad + " frasco: " + this.bolitas);
		this.notifyAll();
	}

	public synchronized void sacar(int cantidad) {
		try {
			while ( cantidad > this.bolitas ) { // IMPORTANTE!!!! while y no if EXPLICAR
				System.out.println(Thread.currentThread().getName() + " esperando");
				this.wait();
			}
			this.bolitas -= cantidad;
			System.out.println(Thread.currentThread().getName() + " saco: " + cantidad + " frasco: " + this.bolitas);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
