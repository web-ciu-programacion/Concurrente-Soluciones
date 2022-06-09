package ar.com.ciu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *  Monitor
 */
public class Buffer {

	public static final int CAPACIDAD = 5;

	private int frente, cola, tamanio;
	private Item[] buffer;

	private Lock lock;
	private Condition noLleno, noVacio;

	public Buffer() {
		super();
		this.lock = new ReentrantLock();
		this.noLleno = this.lock.newCondition(); // hilos que esperan que el buffer no este lleno (productores)
		this.noVacio = this.lock.newCondition(); // hilos que esperan que el buffer no este vacio (consumidores)
		this.buffer = new Item[CAPACIDAD];
		this.tamanio = 0;
	}

	public void insertar(Item item) {
		this.lock.lock(); // obtengo lock del objeto
		try {
			while (this.tamanio == CAPACIDAD) { /* ¿while en vez de if?: https://stackoverflow.com/questions/33186280/why-we-must-use-while-for-checking-race-condition-not-if */
				this.noLleno.await(); // buffer lleno, hilo espera a que se cumpla esta condición (que no esté lleno)
			}
			this.buffer[this.cola] = item;
			this.cola = (this.cola + 1) % CAPACIDAD;
			this.tamanio++;
			this.noVacio.signal(); // se inserto un item en el buffer, se emite un signal por si hay algún hilo
								   // esperando esta condición (que no esté vacío)
								   // IMPORTANTE: Recordar la diferencia con Semaphore.
			System.out.println(Thread.currentThread().getName() + " inserto: " + item.getPalabra());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.lock.unlock(); // libero lock del objeto
		}
	}

	public Item extraer() {
		try {
			this.lock.lock(); // obtengo lock del objeto
			while (this.tamanio==0) {
				this.noVacio.await(); // buffer vacío, hilo espera a que se cumpla esta condición (que no esté vacío)
			}
			Item item = this.buffer[this.frente];
			this.frente = (this.frente + 1) % CAPACIDAD;
			this.tamanio--;
			this.noLleno.signal(); // se extrajo un item del buffer, se emite un signal por si hay algún hilo
								   // esperando esta condición (que no esté lleno)
			   					   // IMPORTANTE: Recordar la diferencia con Semaphore.
			System.out.println(Thread.currentThread().getName() + " extrajo: " + item.getPalabra());
			return item;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		} finally {
			this.lock.unlock(); // libero lock del objeto
		}
	}

}
