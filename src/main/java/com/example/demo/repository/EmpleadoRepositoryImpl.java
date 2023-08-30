package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class EmpleadoRepositoryImpl implements EmpleadoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Empleado empleado) {
		this.entityManager.persist(empleado);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)

	public void actualizar(Empleado empleado) {
		this.entityManager.merge(empleado);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Empleado seleccionar(Integer id) {
		TypedQuery<Empleado> query = this.entityManager.createQuery("SELECT e FROM Empleado e WHERE e.id = :datoId",
				Empleado.class);
		query.setParameter("datoId", id);
		return query.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Empleado seleccinarCedula(String cedula) {
		TypedQuery<Empleado> myQuery = this.entityManager
				.createQuery("SELECT e FROM Empleado e WHERE e.cedula = :datoCedula", Empleado.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Empleado buscarCorreo(String correo) {
		TypedQuery<Empleado> query = this.entityManager
				.createQuery("SELECT e FROM Empleado e WHERE e.correo = :datoCorreo", Empleado.class);
		query.setParameter("datoCorreo", correo);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			System.err.println("No se encontro el correo");
			return null;
		}

	}

	@Override
	public List<Empleado> buscar() {
		TypedQuery<Empleado> query = this.entityManager.createQuery(
				"Select e from Empleado e", Empleado.class);
		return  query.getResultList();
	}

}
