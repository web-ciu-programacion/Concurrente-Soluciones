package ar.com.ciu.parcial.monitor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {

	private Lock lock;
	private Condition clientesEnEspera;
	private int pozoVerde;

	public Monitor() {
		this.lock = new ReentrantLock(true);
		this.clientesEnEspera = this.lock.newCondition();
		this.pozoVerde = 100;
	}
	
	public void comprar(int unaCantidad ) {
		this.lock.lock();
		try {
			while (this.pozoVerde<unaCantidad) {
				this.clientesEnEspera.await();
			}
			this.pozoVerde = this.pozoVerde - unaCantidad;
			System.out.println(Thread.currentThread().getName() + " compro: " + unaCantidad + ". Queda en pozo: " + this.pozoVerde);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.lock.unlock();
		}
	}
	
	public void abastecer(int unaCantidad) {
		this.lock.lock();
		this.pozoVerde = this.pozoVerde + unaCantidad;
		System.out.println(Thread.currentThread().getName() + " abasteció con: " + unaCantidad + ". Queda en pozo: " + this.pozoVerde);
		this.clientesEnEspera.signalAll();
		this.lock.unlock();
	}
}
