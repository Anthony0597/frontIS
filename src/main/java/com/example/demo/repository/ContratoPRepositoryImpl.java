package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.ContratoEmpleados;
import com.example.demo.repository.modelo.ContratoProveedores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ContratoPRepositoryImpl implements IContratoPRespository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(ContratoProveedores cliente) {
		this.entityManager.persist(cliente);
		
	}

	@Override
	public void actualizar(ContratoProveedores cliente) {
		this.entityManager.merge(cliente);
		
	}

	@Override
	public ContratoProveedores buscarId(Integer id) {
		return this.entityManager.find(ContratoProveedores.class, id);
	}

	@Override
	public List<ContratoProveedores> verListaContratos() {
		TypedQuery<ContratoProveedores> myQuery = this.entityManager.createQuery("SELECT c FROM ContratoProveedores c JOIN c.proveedor p", ContratoProveedores.class);
		return myQuery.getResultList();
	}

	

}
