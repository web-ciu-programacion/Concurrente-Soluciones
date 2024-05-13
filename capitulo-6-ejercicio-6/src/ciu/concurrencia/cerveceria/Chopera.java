package ciu.concurrencia.cerveceria;

public class Chopera {

	public synchronized void llenarVaso(Vaso vaso) {
		System.out.println("chopera llenando vaso: " + vaso.getNumero());
		vaso.setEstado(EstadoVaso.LLENO);
	}
}
