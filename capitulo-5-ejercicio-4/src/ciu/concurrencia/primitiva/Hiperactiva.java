package ciu.concurrencia.primitiva;

public class Hiperactiva extends Thread {

	private Auxiliar auxiliar;

	public Hiperactiva(Auxiliar auxiliar) {
		super("hiperactiva");
		this.auxiliar = auxiliar;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " despertando!!!");
		this.auxiliar.despertar();
	}

}
