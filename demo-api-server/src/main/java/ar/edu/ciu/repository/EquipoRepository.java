package ar.edu.ciu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.ciu.entity.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

}
