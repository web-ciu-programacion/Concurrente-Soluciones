package ar.com.ciu.parcial.monitor;

public class Main {

	public static void main(String[] args) {
		Monitor monitor = new Monitor();
		Thread cliente1 = new Thread(new Cliente(monitor, 50), "cliente 1");
		Thread cliente2 = new Thread(new Cliente(monitor, 60), "cliente 2");
		Thread cliente3 = new Thread(new Cliente(monitor, 30), "cliente 3");
		Thread cliente4 = new Thread(new Cliente(monitor, 10), "cliente 4");
		Thread cliente5 = new Thread(new Cliente(monitor, 90), "cliente 5");
		Thread abastecedor1 = new Thread(new Abastecedor(monitor, 250), "abastecedor 1");
		cliente1.start();
		cliente2.start();
		cliente3.start();
		cliente4.start();
		cliente5.start();
		abastecedor1.start();
	}

}
