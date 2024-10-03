package ciu.jpa.repository.impl;

import java.util.List;

import ciu.jpa.model.Cliente;
import ciu.jpa.repository.CustomClienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class CustomClienteRepositoryImpl implements CustomClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Cliente> findAllClientesCustom() {
		String jpql = "SELECT c FROM Cliente c";
		TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
		return query.getResultList();
	}
}
