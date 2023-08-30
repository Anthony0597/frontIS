package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.modelo.Animal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Transactional
@Repository

public class AnimalRepositoryImpl implements IAnimalRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Animal animal) {
		// TODO Auto-generated method stub
		this.entityManager.persist(animal);
	}

	@Override
	public void actualizar(Animal animal) {
		// TODO Auto-generated method stub
		this.entityManager.merge(animal);
	}

	@Override
	public Animal buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Animal.class, id);
	}

	@Override
	public void eliminarId(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(id);
		
	}

	@Override
	public List<Animal> verListaAnimales() {
		// TODO Auto-generated method stub
		TypedQuery<Animal> myQuery = this.entityManager.createQuery(
		       // "SELECT  a FROM Animal a "
	            "SELECT a FROM Animal a "

				,Animal.class);
	
		return myQuery.getResultList();
	}

	
	@Override
	public Animal buscarEspecie(String nombreEspecie) {
		TypedQuery<Animal> myQuery = this.entityManager.createQuery(
				"SELECT a FROM Animal a WHERE a.nombreCientifico=:nombreEspecie",Animal.class);
		myQuery.setParameter("nombreEspecie", nombreEspecie);
		return myQuery.getSingleResult();
	}

}
