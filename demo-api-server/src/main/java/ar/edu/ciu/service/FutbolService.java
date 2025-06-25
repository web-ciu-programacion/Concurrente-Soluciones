package ar.edu.ciu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ar.edu.ciu.entity.Equipo;
import ar.edu.ciu.repository.EquipoRepository;

@Service
public class FutbolService {

	@Autowired
	private EquipoRepository equipoRepository;

	public List<Equipo> findAll() {
		System.out.println("Accediendo al servicio 1.");
		return this.equipoRepository.findAll(); 
	}
	
//	@Cacheable(cacheNames={"equiposStore"}, key="#id")
	public Equipo findById(Long id) {
		System.out.println("Accediendo al servicio EhCache.");
		return this.equipoRepository.findById(id).get(); 
	}

//    @CachePut(value="equipoCache", key="#result.id")
    public Equipo updateEquipo(Equipo nuevoEquipo) {
        Equipo viejoEquipo = this.equipoRepository.findById(nuevoEquipo.getId())
                .orElseThrow(() -> new IllegalArgumentException("Bobo pone bien los id...este no existe: " + nuevoEquipo.getId()));
        viejoEquipo.setName(nuevoEquipo.getName());
        Equipo updatedEquipo = equipoRepository.save(viejoEquipo);
        return updatedEquipo;
    }
    
    public Equipo crear(Equipo equipo) {
    	return this.equipoRepository.save(equipo);
    }
}