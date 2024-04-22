package ciu.concurrente.monitor.lecesc.monitor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Monitor
 * Sincronizador de lecturas / escrituras
 * Prioridad: Lector
 */
public class Sincronizador {

	private Integer lectores;
	private Boolean escribiendo;
	
    private final Lock lock = new ReentrantLock();
    private final Condition lector = lock.newCondition();
    private final Condition escritor = lock.newCondition();

    public Sincronizador() {
    	this.lectores = 0;
    	this.escribiendo = false;
    }
    
    public void abrirLectura() {
		try {
			this.lock.lock();
	    	while (this.escribiendo) {
	    		this.lector.await();
	    	}
	    	this.lectores++;
	    	System.out.println("Lector: " + Thread.currentThread().getName() + " accedio a lectura. " + this.lectores);
	    	this.lector.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.lock.unlock();
		}
    }
    
    public void cerrarLectura() {
		this.lock.lock();
	    this.lectores--;
	    if (this.lectores==0) {
	    	this.escritor.signal();
	    }
	    System.out.println("Lector: " + Thread.currentThread().getName() + " finalizó lectura. " + this.lectores);
	    this.lock.unlock();
    }
    
    public void abrirEscritura() {
		try {
			this.lock.lock();
	    	while (this.lectores!=0 || this.escribiendo) {
				this.escritor.await();
			}
	    	this.escribiendo = true;
	    	System.out.println("Escritor: " + Thread.currentThread().getName() + " accedio a escritura. " + this.lectores);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.lock.unlock();
		}
    }
    
    public void cerrarEscritura() {
    	this.lock.lock();
    	this.escribiendo=false;
    	if ( !((ReentrantLock)this.lock).hasWaiters(this.lector) ) {
			this.escritor.signal();
		}
		this.lector.signal();
    	System.out.println("Escritor: " + Thread.currentThread().getName() + " finalizó escritura. " + this.lectores);
    	this.lock.unlock();
    }
}
