package ciu.ejemplo.docker.ejemplodocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

	@GetMapping("saludo/{nombre}")
	public String saludo(@PathVariable String nombre) {
		return "hola " + nombre;
	}
}
