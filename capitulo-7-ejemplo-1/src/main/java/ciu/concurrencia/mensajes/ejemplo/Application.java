package ciu.concurrencia.mensajes.ejemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 *  Spring Boot App
 *  Aplicación de ejemplo donde se envían mensajes a la queue mediante un endpoint REST.
 *  El consumidor es un Listener.
 */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
