package ciu.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ciu.jpa.model.Cliente;
import ciu.jpa.model.Persona;
import ciu.jpa.repository.ClienteRepository;
import ciu.jpa.repository.PersonaRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PersonaRepository personaRepository;

	public Cliente guardar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	public Cliente getById(Integer id) {
		return this.clienteRepository.findById(id).orElse(null);
	}
	
	public List<Persona> findAll() {
		return this.personaRepository.findAll();
	}
}
