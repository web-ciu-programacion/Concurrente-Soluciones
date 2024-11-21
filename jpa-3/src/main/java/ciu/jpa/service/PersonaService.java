package ciu.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ciu.jpa.model.Persona;
import ciu.jpa.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	public List<Persona> findAll() {
		return this.personaRepository.findAll();
	}
}
