package ciu.concurrencia.practica;

public class Vigilante implements Runnable {

	private Thread hiloVigilado;

	public Vigilante(Thread hilo) {
		super();
		this.hiloVigilado = hilo;
	}

	@Override
	public void run() {
		String ultimoEstado = null;
		
		while ( !"TERMINATED".equals(this.hiloVigilado.getState().name()) ) {
			if (!this.hiloVigilado.getState().name().equals(ultimoEstado)) {
				ultimoEstado = this.hiloVigilado.getState().name();
				System.out.println(this.hiloVigilado.getState().name());
			}
		}
		System.out.println(this.hiloVigilado.getState().name());
	}

}
