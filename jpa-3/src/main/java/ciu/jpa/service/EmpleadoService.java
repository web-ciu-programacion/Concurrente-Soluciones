package ciu.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ciu.jpa.model.Empleado;
import ciu.jpa.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	public Empleado grabar(Empleado empleado) {
		return this.empleadoRepository.save(empleado);
	}
}
