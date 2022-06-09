package ar.com.ciu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MonitorB {

	private Lock lock = new ReentrantLock();
	private Condition liberaA = lock.newCondition();

	public void bloquea() {
		try {
			this.lock.lock();
			liberaA.await();
			this.lock.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void desbloquea() {
		this.lock.lock();
		liberaA.signalAll();
		this.lock.unlock();
	}

}
