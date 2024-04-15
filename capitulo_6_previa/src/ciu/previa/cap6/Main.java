package ciu.previa.cap6;

public class Main {

	public static void main(String[] args) {
		Recurso recurso = new Recurso();
		Consumidor c1 = new Consumidor("Consumidor 1", recurso);
		Consumidor c2 = new Consumidor("Consumidor 2", recurso);
		Consumidor c3 = new Consumidor("Consumidor 3", recurso);
		Consumidor c4 = new Consumidor("Consumidor 4", recurso);
		Consumidor c5 = new Consumidor("Consumidor 5", recurso);
		Productor p1 = new Productor("Productor 1", recurso);
		Productor p2 = new Productor("Productor 2", recurso);
		Productor p3 = new Productor("Productor 3", recurso);
		Productor p4 = new Productor("Productor 4", recurso);
		Productor p5 = new Productor("Productor 5", recurso);
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
	}

}
