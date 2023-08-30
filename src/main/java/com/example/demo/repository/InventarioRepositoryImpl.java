package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Inventario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class InventarioRepositoryImpl implements InventarioRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Inventario inventario) {
		this.entityManager.persist(inventario);

	}

	@Override
	public void actualizar(Inventario inventario) {
		this.entityManager.merge(inventario);
		
	}
	
}
