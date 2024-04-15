package ciu.concurrencia.primitiva;

public class Main {

	public static void main(String[] args) {
		Banderillero banderillero = new Banderillero(6);
		Thread c1 = new Thread(new Corredor(banderillero), "Sena");
		Thread c2 = new Thread(new Corredor(banderillero), "Mansel");
		Thread c3 = new Thread(new Corredor(banderillero), "Fitipaldi");
		Thread c4 = new Thread(new Corredor(banderillero), "Schumacher");
		Thread c5 = new Thread(new Corredor(banderillero), "Fangio");
		Thread c6 = new Thread(new Corredor(banderillero), "Tuero");
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		c6.start();
		while (!banderillero.isCorredoresListos()) {
			System.out.println(c1.getName() + ": " + c1.getState().name());
			System.out.println(c2.getName() + ": " + c2.getState().name());
			System.out.println(c3.getName() + ": " + c3.getState().name());
			System.out.println(c4.getName() + ": " + c4.getState().name());
			System.out.println(c5.getName() + ": " + c5.getState().name());
			System.out.println(c6.getName() + ": " + c6.getState().name());
		}
		banderillero.largar();
	}

}
