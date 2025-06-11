package ar.edu.ciu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.ciu.entity.Equipo;
import ar.edu.ciu.service.FutbolService;

@RestController
public class HelloController {

	@Autowired
	private FutbolService futbolService;
	
    @GetMapping("/hello")
    public String getMessage() {
        return "Aguante Lamadrid!";
    }

    @GetMapping("/equipos")
    public List<Equipo> getEquipos() {
        return this.futbolService.findAll();
    }

    @GetMapping("/equipo/{id}")
    public Equipo getEquipo(@PathVariable Long id) {
        return this.futbolService.findById(id);
    }
    
    @PutMapping("/equipo")
    public Equipo updateEquipo(@RequestBody Equipo nuevoEquipo) {
        return this.futbolService.updateEquipo(nuevoEquipo);
    }
}