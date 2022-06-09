package ciu.concurrencia.semaphore;

import java.util.concurrent.Semaphore;

public class Shared {

	public static Semaphore mutex = new Semaphore(1);

	public static Semaphore cocinero = new Semaphore(0);

	public static Semaphore espera = new Semaphore(0);

}
