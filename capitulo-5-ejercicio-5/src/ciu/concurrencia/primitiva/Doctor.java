package ciu.concurrencia.primitiva;

public class Doctor extends Thread {

	private Auxiliar auxiliar;

	public Doctor(Auxiliar auxiliar) {
		super("Doctor");
		this.auxiliar = auxiliar;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " llama un paciente");
		this.auxiliar.atender();
	}

}
