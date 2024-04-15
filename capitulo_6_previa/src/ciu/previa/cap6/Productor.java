package ciu.previa.cap6;

public class Productor extends Thread {

	private Recurso recurso;

	public Productor(String nombre, Recurso recurso) {
		super(nombre);
		this.recurso = recurso;
	}

	@Override
	public void run() {
		try {
			this.recurso.produce();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	

}
