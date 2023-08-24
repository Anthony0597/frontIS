package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Cliente cliente) {
		this.entityManager.persist(cliente);
		
	}

	@Override
	public void actualizar(Cliente cliente) {
		this.entityManager.merge(cliente);
		
	}

	@Override
	public Cliente buscarId(Integer id) {
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	public void eliminarId(Integer id) {
		this.entityManager.remove(id);
		
	}

	@Override
	public List<Cliente> verListaClientesVIP() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c.cedula FROM Cliente c",Cliente.class);
		return myQuery.getResultList();
	}
	

}
