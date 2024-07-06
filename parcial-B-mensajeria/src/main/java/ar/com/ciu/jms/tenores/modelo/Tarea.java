package ar.com.ciu.jms.tenores.modelo;

public class Tarea {

	private String descripcion;
	
	public Tarea(String descripcion) {
		this.descripcion = descripcion;
	}

	public void realizar() {
		System.out.println(
			Thread.currentThread().getName() 
			+ " realizó la tarea: " 
			+ this.descripcion
		);
	}
}
