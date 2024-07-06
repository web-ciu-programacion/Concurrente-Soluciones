package ar.com.ciu.parcial.b.ejercicio;

import java.util.concurrent.Semaphore;

/*
 * Respuestas:
 * 
 * 1 - El acceso a la variable: Compartida.total está garantizado por el semáforo mutex: semA.
 * 
 * 2 - No finaliza, se ejecutan 3 hilos que hacen un acquire al semáforo: semB; y este está inicializado en 2, por 
 *     lo tanto, 2 hilos finalizan y 1 no.
 *     Solución: Inicializar el semáforo semB en 3.
 *     
 * 3 - Traza posible:
 *     x sumo 1.
 *     y sumo 2.
 *     z sumo 3.
 *     valor: 6.
 *     main fin.
 *     
 * 4 - No se puede afirmar que hilo inicia primero, esto es ajeno a la aplicación, depende del Sistema Operativo.
 * 
 */
public class Main {

	public static void main(String[] args) {
		try {
			Semaphore semA = new Semaphore(1);
			Semaphore semB = new Semaphore(3);
			Thread sa = new SumadorA(semA, semB, "x");
			Thread sb = new SumadorB(semA, semB, "y");
			Thread sc = new SumadorC(semA, semB, "z");
			sa.start();	sb.start();	sc.start();
			sa.join(); sb.join(); sc.join();
			System.out.println("valor: " 
			  + Compartida.total + ".");
		} catch (InterruptedException e) {
			System.out.println("maldita sea...");
		} finally {
			System.out.println(
			  Thread.currentThread().getName() + " fin.");
		}
	}

}
