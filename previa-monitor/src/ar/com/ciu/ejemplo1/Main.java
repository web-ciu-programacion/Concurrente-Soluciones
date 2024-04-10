package ar.com.ciu.ejemplo1;

public class Main {

	// En este ejemplo podemos observar como de a un hilo a la vez ingresan
	// al método: deAUnoPorFavor de la clase Sincronizada.
	// Una vez que un hilo entra a dicho método, el resto tiene que esperar que este 
	// salga, son 5 segundos que permanece dentro.
	public static void main(String[] args) {
		Sincronizada s = new Sincronizada();
		Thread ha = new HiloA(s);
		Thread hb = new HiloB(s);
		ha.start();
		hb.start();
	}

}
