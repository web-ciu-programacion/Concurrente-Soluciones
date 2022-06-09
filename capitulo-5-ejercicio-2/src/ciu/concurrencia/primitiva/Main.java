package ciu.concurrencia.primitiva;

public class Main {

	public static void main(String[] args) {
		Dado s = new Dado();
		Thread ha = new HiloA(s);
		Thread hb = new HiloB(s);
		Thread hc = new HiloC(s);
		Thread hd = new HiloD(s);
		ha.start();
		hb.start();
		hc.start();
		hd.start();
	}

}
