package cena.filosofo;

import java.util.concurrent.Semaphore;

public class Filosofo implements Runnable {

	private int lugar;
	private Semaphore sitio;
	private Semaphore[] palillo;
	
	public Filosofo(int lugar, Semaphore sitio, Semaphore[] palillo) {
		this.sitio = sitio;
		this.palillo = palillo;
		this.lugar = lugar;
	}
	
	@Override
	public void run() {
		try {
			int i = 0;
			while(i<10) { // en este ejemplo cada filósofo come 10 veces, el problema original plantea un loop infinito			
				this.pensar();
				this.sitio.acquire();
				this.palillo[this.lugar].acquire();
				this.palillo[(this.lugar+1) % 5].acquire();
				this.empezarAComer();
				this.palillo[this.lugar].release();
				this.palillo[(this.lugar+1) % 5].release();
				this.terminarDeComer();
				this.sitio.release();
				i++;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void pensar() {
		System.out.println(Thread.currentThread().getName() + ": estoy pensando...");
	}
	
	private void empezarAComer() {
		System.out.println(Thread.currentThread().getName() + ": COMIENDO con palillos: " + this.lugar + " y " + (this.lugar+1));
	}

	private void terminarDeComer() {
		System.out.println(Thread.currentThread().getName() + ": TERMINO de comer, libera palillos: " + this.lugar + " y " + (this.lugar+1));
	}

}
