package ciu.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ciu.jpa.model.Empleado;
import ciu.jpa.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	public Empleado guardar(Empleado empleado) {
		return this.empleadoRepository.save(empleado);
	}

	public Empleado getById(Integer id) {
		return this.empleadoRepository.findById(id).orElse(null);
	}
	
	public List<Empleado> findAll() {
		return this.empleadoRepository.findAll();
	}
}
