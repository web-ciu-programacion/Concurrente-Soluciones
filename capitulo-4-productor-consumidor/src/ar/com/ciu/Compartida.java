package ar.com.ciu;

public class Compartida {

	public final static int TAMANIO_BUFFER = 5;

	public static Item[] buffer = new Item[TAMANIO_BUFFER]; 

	public static int cola = 0;

	public static int frente = 0;

}
