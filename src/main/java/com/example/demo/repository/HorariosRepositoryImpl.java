package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Horarios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HorariosRepositoryImpl implements IHorarioRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Horarios horarios) {
		this.entityManager.merge(horarios);
		
	}

	@Override
	public void actualizar(Horarios horarios) {
		this.entityManager.merge(horarios);
		
	}

	@Override
	public void eliminar(Horarios horarios) {
		this.entityManager.remove(horarios);
		
	}

	@Override
	public Horarios seleccionar(Integer id) {
		return this.entityManager.find(Horarios.class, id);
	}


	
}
