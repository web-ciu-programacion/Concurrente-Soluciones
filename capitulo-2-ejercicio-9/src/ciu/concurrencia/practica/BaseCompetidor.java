package ciu.concurrencia.practica;

public class BaseCompetidor {

	protected int kilometros;

	protected int getNumero() {
		return (int)(Math.random() * 10) + 1;		
	}

}
