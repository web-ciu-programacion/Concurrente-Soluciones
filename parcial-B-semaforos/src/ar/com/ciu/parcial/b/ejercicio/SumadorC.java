package ar.com.ciu.parcial.b.ejercicio;

import java.util.concurrent.Semaphore;

public class SumadorC extends Thread {

	private Semaphore s1;
	private Semaphore s2;

	public SumadorC(Semaphore s1, Semaphore s2, String xyz) {
		super(xyz);
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void run() {
		try {
			this.s2.acquire();
			this.s1.acquire();
			Compartida.total += 3;
			this.s1.release();
			System.out.println(
			  Thread.currentThread().getName() + " sumo 3.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}