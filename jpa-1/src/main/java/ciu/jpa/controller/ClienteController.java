package ciu.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ciu.jpa.dto.ClienteDto;
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
	public ClienteDto buscar(@PathVariable Integer id) {
		Cliente cliente = this.clienteService.getByIdConFacturas(id);
		ClienteDto clienteDto = new ClienteDto(cliente, true);
		return clienteDto;
	}
	
	@GetMapping("/all")
	public List<ClienteDto> buscarTodos() {
		List<Cliente> clientes = this.clienteService.getClientes();
		List<ClienteDto> clientesDtos = new ArrayList<ClienteDto>();
		clientes.forEach(cliente -> {
			ClienteDto clienteDto = new ClienteDto(cliente, false);
			clientesDtos.add(clienteDto);
		});
		return clientesDtos;
	}

}
