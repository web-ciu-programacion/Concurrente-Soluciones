package ar.com.ciu.recuperatorio.monitor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {

	public static final int CANTIDAD_CONFESIONARIOS = 2;
	
	private Lock lock;
	private Condition[] confesionariosNoLleno;
	private boolean[] confesionariosVacios;
	
	public Monitor() {
		this.lock = new ReentrantLock(true);
		this.confesionariosNoLleno = new Condition[CANTIDAD_CONFESIONARIOS];
		this.confesionariosVacios = new boolean[CANTIDAD_CONFESIONARIOS];
		this.iniciarConfesionarios();
	}

	public void entrarAConfesionario(int numeroDeConfesionario) {
		this.lock.lock();
		try {
			while (!this.confesionariosVacios[numeroDeConfesionario]) {
				this.confesionariosNoLleno[numeroDeConfesionario].await();
			}
			this.confesionariosVacios[numeroDeConfesionario] = false;
			System.out.println(Thread.currentThread().getName() + " entro a confesionaroio " + numeroDeConfesionario);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.lock.unlock();
		}
	}
	
	public void abandonarConfesionario(int numeroDeConfesionario) {
		this.lock.lock();
		try {
			this.confesionariosVacios[numeroDeConfesionario] = true;
			this.confesionariosNoLleno[numeroDeConfesionario].signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.lock.unlock();
		}
	}
	
	private void iniciarConfesionarios() {
		for (int i = 0; i < confesionariosVacios.length; i++) {
			this.confesionariosVacios[i] = true;
			this.confesionariosNoLleno[i] = this.lock.newCondition();
		}
	}
}
