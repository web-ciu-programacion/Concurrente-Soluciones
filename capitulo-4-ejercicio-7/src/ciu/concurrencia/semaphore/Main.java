package ciu.concurrencia.semaphore;

public class Main {

	public static void main(String[] args) {
		Terminal t1 = new Terminal();
		Terminal t2 = new Terminal();
		Terminal t3 = new Terminal();
		Terminal t4 = new Terminal();
		Terminal t5 = new Terminal();
		Thread th1 = new Thread(t1, "terminal-1");
		Thread th2 = new Thread(t2, "terminal-2");
		Thread th3 = new Thread(t3, "terminal-3");
		Thread th4 = new Thread(t4, "terminal-4");
		Thread th5 = new Thread(t5, "terminal-5");
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
	}

}
