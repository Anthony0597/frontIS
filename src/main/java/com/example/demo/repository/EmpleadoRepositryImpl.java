package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.demo.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmpleadoRepositryImpl implements IEmpleadoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Empleado cliente) {
		this.entityManager.persist(cliente);
		
	}

	@Override
	public List<Empleado> verListaEmpleados() {
		TypedQuery<Empleado> myQuery = this.entityManager.createQuery("SELECT c.empleado FROM Contrato", Empleado.class);
		return myQuery.getResultList();
	}

}
