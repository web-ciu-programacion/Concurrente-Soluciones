package ciu.concurrencia.practica.sinhilos;

public class Caja {

	private String numeroDeCaja;
	
	public Caja(String numeroDeCaja) {
		super();
		this.numeroDeCaja = numeroDeCaja;
	}
	
	public void cobrar(Cliente unCliente) {
		unCliente.getProductos().forEach(p -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println(Thread.currentThread().getName() + " cobó: " + unCliente.getProductos().size() + " productos.");
	}

	public String getNumeroDeCaja() {
		return numeroDeCaja;
	}

}
