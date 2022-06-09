package ciu.concurrencia.semaphore;

import java.util.concurrent.Semaphore;

public class Shared {

	public static Semaphore puenteNorte = new Semaphore(1);
	public static Semaphore puenteSur = new Semaphore(1);

}
