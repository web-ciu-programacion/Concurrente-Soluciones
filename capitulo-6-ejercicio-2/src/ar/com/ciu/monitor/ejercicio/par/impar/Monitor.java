package ar.com.ciu.monitor.ejercicio.par.impar;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {

	private Lock lock;
	private Condition par;
	private Condition impar;

	public Monitor() {
		super();
		this.lock = new ReentrantLock();
		this.par = this.lock.newCondition();
		this.impar = this.lock.newCondition();
	}

	public void accion(int numero) {
		this.lock.lock();
		Thread t = Thread.currentThread();
		try {
			if (numero==1 || numero==3 || numero==5 || numero==7) {
				System.out.println(t.getName() + " bloqueado en impar");
				this.impar.await();
			} else if (numero==2 || numero==4 || numero==6 || numero==8) {
				System.out.println(t.getName() + " bloqueado par");
				this.par.await();
			} else if (numero==9) {
				System.out.println(t.getName() + " libera impares");
				this.impar.signalAll();
			} else if (numero==10) {
				System.out.println(t.getName() + " libera pares");
				this.par.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.lock.unlock();
		}
	}

}
