package ciu.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ciu.jpa.model.Persona;
import ciu.jpa.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@GetMapping
	public List<Persona> buscar() {
		List<Persona> personas = this.personaService.findAll();
		return personas;
	}

}
