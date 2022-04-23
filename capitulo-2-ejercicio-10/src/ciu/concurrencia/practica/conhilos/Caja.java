package ciu.concurrencia.practica.conhilos;

public class Caja implements Runnable {
	
	private Cliente cliente;
	
	public Caja(Cliente cliente) {
		super();
		this.cliente = cliente;
	}	

	@Override
	public void run() {
		cliente.getProductos().forEach(p -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println(Thread.currentThread().getName() + " cobó: " + cliente.getProductos().size() + " productos.");
	}

}
