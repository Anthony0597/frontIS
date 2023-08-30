package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Asignacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class AsignacionRepositoryImpl implements AsignacionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Asignacion asignacion) {
		this.entityManager.persist(asignacion);
	}

	@Override
	public void actualizar(Asignacion asignacion) {
		this.entityManager.merge(asignacion);
	}

	@Override
	public Asignacion seleccionar(Integer id) {
	//	TypedQuery<Asignacion> query = this.entityManager.createQuery(
		//		"SELECT c FROM Asignacion c JOIN FETCH c.propietario WHERE c.numero = :numero", Asignacion.class);

	//	return query.getSingleResult();
		return null;
	}

}
