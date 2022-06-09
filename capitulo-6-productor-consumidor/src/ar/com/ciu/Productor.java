package ar.com.ciu;

public class Productor extends Thread {

		// atributos
	private Buffer buffer;
	private Item item;

		// constructor
	public Productor(String nombre, Buffer buffer, Item item) {
		super(nombre);
		this.buffer= buffer;
		this.item = item;
	}

		// metodos
	@Override
	public void run() {
		this.buffer.insertar(this.item);
	}

}
