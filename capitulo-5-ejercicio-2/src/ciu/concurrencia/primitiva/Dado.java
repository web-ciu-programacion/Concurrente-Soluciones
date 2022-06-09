package ciu.concurrencia.primitiva;

public class Dado  {

	public synchronized int darNumero() {
		int numero = (int)(Math.random() * 6) + 1;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return numero;
	}

}
