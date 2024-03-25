package ciu.concurrencia.semaphore;

public class Main {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Auto(Sentido.NORTE_SUR), "auto rojo");
		Thread t2 = new Thread(new Auto(Sentido.NORTE_SUR), "auto azul");
		Thread t3 = new Thread(new Auto(Sentido.NORTE_SUR), "auto verde");
		Thread t4 = new Thread(new Auto(Sentido.SUR_NORTE), "auto morado");
		Thread t5 = new Thread(new Auto(Sentido.SUR_NORTE), "auto negro");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
