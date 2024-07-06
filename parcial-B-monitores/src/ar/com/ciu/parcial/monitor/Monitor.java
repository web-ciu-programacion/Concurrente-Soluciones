package ar.com.ciu.parcial.monitor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {

	private Lock lock;
	// tipos de infraccion
	private Condition ebriedad;
	private Condition ecologica;
	private Condition transito;

	public Monitor() {
		super();
		this.lock = new ReentrantLock(true);
		this.ebriedad = this.lock.newCondition();
		this.ecologica = this.lock.newCondition();
		this.transito = this.lock.newCondition();
	}

	public void retenerInfractor(Infractor infractor) {
		this.lock.lock();
		try {
			Thread t = Thread.currentThread();
			if (Infractor.EBRIEDAD.equals(infractor.getInfraccionCometida())) {
				System.out.println(t.getName() + " retenido por infraccion: " + infractor.getInfraccionCometida());
				this.ebriedad.await();
			} else if (Infractor.ECOLOGICA.equals(infractor.getInfraccionCometida())) {
				System.out.println(t.getName() + " retenido por infraccion: " + infractor.getInfraccionCometida());
				this.ecologica.await();
			} else if (Infractor.TRANSITO.equals(infractor.getInfraccionCometida())) {
				System.out.println(t.getName() + " retenido por infraccion: " + infractor.getInfraccionCometida());
				this.transito.await();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.lock.unlock();
		}
	}

	public void liberarInfractores(String causa) {
		this.lock.lock();
		try {
			Thread t = Thread.currentThread();
			if (Infractor.EBRIEDAD.equals(causa)) {
				System.out.println(t.getName() + " LIBERA detenidos por infraccion: " + causa);
				this.ebriedad.signalAll();
			} else if (Infractor.ECOLOGICA.equals(causa)) {
				System.out.println(t.getName() + " LIBERA detenidos por infraccion: " + causa);
				this.ecologica.signalAll();
			} else if (Infractor.TRANSITO.equals(causa)) {
				System.out.println(t.getName() + " LIBERA detenidos por infraccion: " + causa);
				this.transito.signalAll();
			}
		} finally {
			this.lock.unlock();
		}
	}

}
