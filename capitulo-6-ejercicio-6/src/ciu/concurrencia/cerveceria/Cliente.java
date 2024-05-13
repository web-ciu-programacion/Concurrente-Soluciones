package ciu.concurrencia.cerveceria;

public class Cliente implements Runnable {

	private int cantidadDeVasosATomar;
	private int cantidadDeVasosTomados;
	private Estante estanteDeVasosVacios;
	private Estante estanteDeVasosLlenos;
	
	public Cliente(int cantidadDeVasosATomar, Estante estanteDeVasosVacios, Estante estanteDeVasosLlenos) {
		this.cantidadDeVasosATomar = cantidadDeVasosATomar;
		this.cantidadDeVasosTomados = 0;
		this.estanteDeVasosVacios = estanteDeVasosVacios;
		this.estanteDeVasosLlenos = estanteDeVasosLlenos;
	}
	
	@Override
	public void run() {
		while (this.cantidadDeVasosTomados<this.cantidadDeVasosATomar) {
			Vaso vaso = this.agarrarVasoLleno();
			this.cantidadDeVasosTomados++;
			System.out.println(Thread.currentThread().getName() + " tomando el vaso: " + this.cantidadDeVasosTomados);
			this.ponerVasoVacio(vaso);
		}
		System.out.println(Thread.currentThread().getName() + " se retiro vaya a saber donde...");
	}
	
	private Vaso agarrarVasoLleno() {
		return this.estanteDeVasosLlenos.agarrar();
	}

	private void ponerVasoVacio(Vaso vaso) {
		this.estanteDeVasosVacios.poner(vaso);
	}
}
