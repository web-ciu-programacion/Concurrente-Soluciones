package ciu.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ciu.jpa.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
