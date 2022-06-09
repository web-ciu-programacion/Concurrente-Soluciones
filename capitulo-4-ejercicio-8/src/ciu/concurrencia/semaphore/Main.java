package ciu.concurrencia.semaphore;

public class Main {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Auto(), "auto rojo");
		Thread t2 = new Thread(new Auto(), "auto azul");
		Thread t3 = new Thread(new Auto(), "auto verde");
		Thread t4 = new Thread(new Auto(), "auto morado");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
