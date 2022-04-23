package ciu.concurrencia.practica.sinhilos;

public class Main {

	public static void main(String[] args) {
		Producto jabon = new Producto("Jabón");
		Producto lavandina = new Producto("Lavandina");
		Producto ravioles = new Producto("Ravioles");
		Producto mostaza = new Producto("Mostaza");
		Producto queso = new Producto("Queso blanco");
		Producto cerveza = new Producto("Cerveza");
		Producto fernet = new Producto("Fernet");
		Producto soda = new Producto("Soda");
		Producto mani = new Producto("Maní");
		Cliente juana = new Cliente("Juana");
		juana.agregar(fernet);
		juana.agregar(lavandina);
		Cliente pedro = new Cliente("Pedro");
		pedro.agregar(cerveza);
		pedro.agregar(mani);
		pedro.agregar(jabon);
		pedro.agregar(soda);
		Cliente lucrecia = new Cliente("Lucrecia");
		lucrecia.agregar(queso);
		lucrecia.agregar(ravioles);
		lucrecia.agregar(mostaza);
		Caja uno = new Caja("Uno");
		Caja dos = new Caja("Dos");
		Caja tres = new Caja("Tres");
		long startTime = System.currentTimeMillis();
		uno.cobrar(lucrecia);
		dos.cobrar(pedro);
		tres.cobrar(juana);
		long time = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo total en milisegundos: " + time);
	}

}
