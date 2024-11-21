package ciu.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ciu.jpa.model.Cliente;
import ciu.jpa.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente guardar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	public Cliente getById(Integer id) {
		return this.clienteRepository.findById(id).orElse(null);
	}
}
