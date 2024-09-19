package ciu.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ciu.jpa.model.Cliente;
import ciu.jpa.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public Cliente grabar(@RequestBody Cliente cliente) {
		return this.clienteService.guardar(cliente);
	}
}
