package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Contrato;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ContratoRepositoryImpl implements IContratoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Contrato cliente) {
		this.entityManager.persist(cliente);
		
	}

	@Override
	public void actualizar(Contrato cliente) {
		this.entityManager.merge(cliente);
		
	}

	@Override
	public Contrato buscarId(Integer id) {
		return this.entityManager.find(Contrato.class, id);
	}

	@Override
	public void eliminarId(Integer id) {
		this.entityManager.remove(id);
		
	}

	@Override
	public List<Contrato> verListaContratosEmpleados() {
		TypedQuery<Contrato> myQuery = this.entityManager.createQuery("SELECT c.numero FROM Contrato c JOIN c.empleado e", Contrato.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Contrato> verListaContratosProveedores() {
		TypedQuery<Contrato> myQuery = this.entityManager.createQuery("SELECT c.numero FROM Contrato c JOIN c.proveedor p", Contrato.class);
		return myQuery.getResultList();
	}

}
