package ar.com.ciu.ejemplo4;

public class Main {

	public static void main(String[] args) {
		AuxiliarUno aux1 = new AuxiliarUno();
		Thread hiloA = new HiloA(aux1);
		Thread hiloB = new HiloB(aux1);

		AuxiliarDos aux2 = new AuxiliarDos();
		Thread hiloC = new HiloC(aux2);
		Thread hiloD = new HiloD(aux2);
		Thread hiloE = new HiloE(aux2);

		hiloA.start();
		hiloB.start();

		hiloC.start();
		hiloD.start();
		hiloE.start();
	}

}
