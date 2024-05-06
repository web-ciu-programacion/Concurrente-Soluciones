package ar.com.ciu.monitor.bolitas;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Frasco {

	private int bolitas;
	private Lock lock;
	private Condition sinBolitas;

	public Frasco() {
		super();
		this.bolitas = 0;
		this.lock = new ReentrantLock();
		this.sinBolitas = this.lock.newCondition();
	}

	public void poner(int cantidad) {
		this.lock.lock();
		this.bolitas += cantidad;
		System.out.println(Thread.currentThread().getName() + " puso: " + cantidad + " frasco: " + this.bolitas);
		this.sinBolitas.signalAll();
		this.lock.unlock();
	}

	public void sacar(int cantidad) {
		try {
			this.lock.lock();
			while ( cantidad > this.bolitas ) { // IMPORTANTE!!!! while y no if EXPLICAR
				System.out.println(Thread.currentThread().getName() + " esperando");
				this.sinBolitas.await();
			}
			this.bolitas -= cantidad;
			System.out.println(Thread.currentThread().getName() + " saco: " + cantidad + " frasco: " + this.bolitas);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.lock.unlock();
		}
	}

}
