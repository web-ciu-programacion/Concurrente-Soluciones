package ciu.concurrencia.primitiva;

public class Paciente extends Thread {

	private Auxiliar auxiliar;

	public Paciente(String nombre, Auxiliar auxiliar) {
		super(nombre);
		this.auxiliar = auxiliar;
	}

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() +  " esperando...");
		this.auxiliar.esperar();
		System.out.println(t.getName() +  " atendido");
	}

}
