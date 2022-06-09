package ar.com.ciu;

public class MainProductoConsumidor {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		Thread p1 = new Productor("prod 1", buffer, new Item("Lamadrid"));
		Thread p2 = new Productor("prod 2", buffer, new Item("el"));
		Thread p3 = new Productor("prod 3", buffer, new Item("mas"));
		Thread p4 = new Productor("prod 4", buffer, new Item("grande"));
		Thread p5 = new Productor("prod 5", buffer, new Item("por"));
		Thread p6 = new Productor("prod 6", buffer, new Item("siempre"));
		Thread p7 = new Productor("prod 7", buffer, new Item("!!!"));
		Thread c1 = new Consumidor("cons 1", buffer);
//		Thread c2 = new Consumidor("cons 2", buffer);
//		Thread c3 = new Consumidor("cons 3", buffer);
//		Thread c4 = new Consumidor("cons 4", buffer);
//		Thread c5 = new Consumidor("cons 5", buffer);
//		Thread c6 = new Consumidor("cons 6", buffer);
//		Thread c7 = new Consumidor("cons 7", buffer);
		c1.start();
//		c2.start();
//		c3.start();
//		c4.start();
//		c5.start();
//		c6.start();
//		c7.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		p7.start();
	}

}
