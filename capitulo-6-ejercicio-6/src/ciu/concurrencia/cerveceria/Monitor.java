package ciu.concurrencia.cerveceria;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {

	private Lock lock;
	private Condition esperandoVasoLleno;
	private Condition esperandoVasoVacio;
	private Condition esperandoLugarDeVasoLleno;
	private Condition esperandoLugarDeVasoVacio;
	
	public Monitor() {
		this.lock = new ReentrantLock();
		this.esperandoVasoLleno = this.lock.newCondition();
		this.esperandoVasoVacio = this.lock.newCondition();
		this.esperandoLugarDeVasoLleno = this.lock.newCondition();
		this.esperandoLugarDeVasoVacio = this.lock.newCondition();
	}

	public Vaso quitarVaso(Estante estante) {
		try {
			this.lock.lock();
			//System.out.println("quitarVaso: " + estante.toString());
			while (!estante.hayVaso()) {
				if (estante.esDeVasosLlenos()) {
					this.esperandoVasoLleno.await();
				} else {
					this.esperandoVasoVacio.await();
				}
			}
			if (estante.esDeVasosLlenos()) {
				this.esperandoLugarDeVasoLleno.signalAll();
			} else {
				this.esperandoLugarDeVasoVacio.signalAll();
			}
			Vaso vaso = estante.obtenerPrimerVaso();
			//System.out.println("quitarVaso: " + estante.toString());
			return vaso;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		} finally {
			this.lock.unlock();
		}
	}

	public void ponerVaso(Vaso vaso, Estante estante) {
		try {
			this.lock.lock();
			//System.out.println("ponerVaso: " + estante.toString());
			while (!estante.hayLugar()) {
				if (estante.esDeVasosLlenos()) {
					this.esperandoLugarDeVasoLleno.await();
				} else {
					this.esperandoLugarDeVasoVacio.await();
				}
			}
			estante.getVasos().add(vaso);
			//System.out.println("ponerVaso: " + estante.toString());
			if (estante.esDeVasosLlenos()) {
				this.esperandoVasoLleno.signalAll();
			} else {
				this.esperandoVasoVacio.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.lock.unlock();
		}
	}
}