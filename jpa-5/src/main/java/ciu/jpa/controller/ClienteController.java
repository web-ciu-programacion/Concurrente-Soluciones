package ciu.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ciu.jpa.model.Cliente;
import ciu.jpa.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public Cliente grabar(@RequestBody Cliente cliente) {
		return this.clienteService.guardar(cliente);
	}
	
	@GetMapping("/{id}")
	public Cliente buscar(@PathVariable Integer id) {
		Cliente cliente = this.clienteService.getById(id);
		return cliente;
	}
}