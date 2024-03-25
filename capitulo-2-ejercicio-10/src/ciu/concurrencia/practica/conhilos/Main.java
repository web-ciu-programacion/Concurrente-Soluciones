package ciu.concurrencia.practica.conhilos;

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
		Thread cajaUno = new Thread(new Caja(lucrecia), "Caja 1");
		Thread cajaDos = new Thread(new Caja(pedro), "Caja 2");
		Thread cajaTres = new Thread(new Caja(juana), "Caja 3");
		long startTime = System.currentTimeMillis();
		cajaUno.start();
		cajaDos.start();
		cajaTres.start();
		while ( 
			!"TERMINATED".equals(cajaUno.getState().name()) ||  
			!"TERMINATED".equals(cajaDos.getState().name()) ||  
			!"TERMINATED".equals(cajaTres.getState().name()) 
		) {
		}
		long time = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo total en milisegundos: " + time);
	}

}
