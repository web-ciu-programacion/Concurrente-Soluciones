package ciu.concurrencia.semaphore;

import java.util.concurrent.Semaphore;

public class Shared {

	public static boolean[] libre = {true, true, true};

	public static Semaphore impresoras = new Semaphore(3);

	public static Semaphore mutex = new Semaphore(1);

}
