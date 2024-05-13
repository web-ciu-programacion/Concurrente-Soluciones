package ciu.concurrencia.cerveceria;

public class Barman implements Runnable {

	private int cantidadDeVasosLlenados;
	private Estante estanteDeVasosVacios;
	private Estante estanteDeVasosLlenos;
	private Chopera chopera;
	
	public Barman(Chopera chopera, Estante estanteDeVasosVacios, Estante estanteDeVasosLlenos) {
		this.cantidadDeVasosLlenados = 1;
		this.estanteDeVasosVacios = estanteDeVasosVacios;
		this.estanteDeVasosLlenos = estanteDeVasosLlenos;
		this.chopera = chopera;
	}
	
	@Override
	public void run() {
		while (this.cantidadDeVasosLlenados<=3) {
			Vaso vaso = this.agarrarVasoVacio();
			System.out.println(Thread.currentThread().getName() + " llenando el vaso: " + this.cantidadDeVasosLlenados);
			this.chopera.llenarVaso(vaso);
			this.cantidadDeVasosLlenados++;
			this.ponerVasoLleno(vaso);
		}
		System.out.println(Thread.currentThread().getName() + " se retiro feliz.");
	}

	private Vaso agarrarVasoVacio() {
		return this.estanteDeVasosVacios.agarrar();
	}

	private void ponerVasoLleno(Vaso vaso) {
		this.estanteDeVasosLlenos.poner(vaso);
	}

	public Chopera getChopera() {
		return chopera;
	}
}
