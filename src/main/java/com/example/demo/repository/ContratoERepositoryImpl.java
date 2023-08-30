package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.ContratoEmpleados;
import com.example.demo.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ContratoERepositoryImpl implements IContratoERepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(ContratoEmpleados empleado) {
		this.entityManager.persist(empleado);
	}

	@Override
	public void actualizar(Empleado empleado, ContratoEmpleados contrato) {
		this.entityManager.merge(empleado);	
		this.entityManager.merge(contrato);	
	}

	@Override
	public ContratoEmpleados buscarId(Integer id) {
		return this.entityManager.find(ContratoEmpleados.class, id);
	}


	@Override
	public List<ContratoEmpleados> verListaContratos() {
		TypedQuery<ContratoEmpleados> myQuery = this.entityManager.createQuery("SELECT ce FROM ContratoEmpleados ce", ContratoEmpleados.class);
		return myQuery.getResultList();
	}

	@Override
	public ContratoEmpleados buscarContratoActivoEmpleado(Empleado empleado) {
		TypedQuery<ContratoEmpleados> query = entityManager.createQuery(
	            "SELECT ce FROM ContratoEmpleados ce WHERE ce.empleado = :empleado AND ce.estado = true", 
	            ContratoEmpleados.class
	        );
	        query.setParameter("empleado", empleado);

	        try {
	            return query.getSingleResult();
	        } catch (NoResultException e) {
	            return null; // No se encontró un contrato activo para el empleado
	        }
	}


}
