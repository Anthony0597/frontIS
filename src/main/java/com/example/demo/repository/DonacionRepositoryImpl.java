package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Donacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DonacionRepositoryImpl implements IDonacionRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void agregarDonacion(Donacion donacion) {
		this.entityManager.persist(donacion);
		
	}

	@Override
	public Donacion obtenerDonacionPorId(int id) {
		return this.entityManager.find(Donacion.class, id);
	}

	@Override
	public List<Donacion> obtenerTodasLasDonaciones() {
		Query query = entityManager.createQuery("SELECT d FROM Donacion d");
        return query.getResultList();
	}

	@Override
	public BigDecimal obtenerMontoTotalDonaciones() {
		Query query = entityManager.createQuery("SELECT SUM(d.monto) FROM Donacion d");
        return (BigDecimal) query.getSingleResult();
	}

}
