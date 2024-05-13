package ciu.concurrencia.cerveceria;

public class Main {

	public static void main(String[] args) {
		Monitor monitor = new Monitor();
		Chopera chopera = new Chopera();
		Estante estanteDeVasosVacios = new EstanteVasosVacios(5, monitor);
		Estante estanteDeVasosLlenos = new EstanteVasosLlenos(5, monitor);
		estanteDeVasosVacios.poner(new Vaso(1));
		estanteDeVasosVacios.poner(new Vaso(2));
		estanteDeVasosVacios.poner(new Vaso(3));
		estanteDeVasosVacios.poner(new Vaso(4));
		estanteDeVasosVacios.poner(new Vaso(5));
		Thread barman1 = new Thread(new Barman(chopera, estanteDeVasosVacios, estanteDeVasosLlenos), "barman 1");
		Thread barman2 = new Thread(new Barman(chopera, estanteDeVasosVacios, estanteDeVasosLlenos), "barman 2");
		Thread cliente1 = new Thread(new Cliente(2, estanteDeVasosVacios, estanteDeVasosLlenos), "cliente 1");
		Thread cliente2 = new Thread(new Cliente(2, estanteDeVasosVacios, estanteDeVasosLlenos), "cliente 2");
		Thread cliente3 = new Thread(new Cliente(3, estanteDeVasosVacios, estanteDeVasosLlenos), "cliente 3");
		barman1.start();
		barman2.start();
		cliente1.start();
		cliente2.start();
		cliente3.start();
	}

}
