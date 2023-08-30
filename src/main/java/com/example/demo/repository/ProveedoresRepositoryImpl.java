package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Proveedor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class ProveedoresRepositoryImpl implements IProveedorRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Proveedor proveedor) {
		this.entityManager.persist(proveedor);
		
	}

	@Override
	public void actualizar(Proveedor proveedor) {
		this.entityManager.merge(proveedor);
		
	}

	@Override
	public Proveedor buscarId(Integer id) {
		return this.entityManager.find(Proveedor.class, id);
	}

	@Override
	public void eliminarId(Integer id) {
		this.entityManager.remove(id);
		
	}

	@Override
	public List<Proveedor> reporteProveedor() {
		TypedQuery<Proveedor> myQuery = this.entityManager.createQuery("SELECT p FROM Proveedor p",Proveedor.class);
		return myQuery.getResultList();

	}

	@Override
	public Proveedor buscarNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Proveedor> myQuery 
			= this.entityManager.createQuery("SELECT p FROM Proveedor p WHERE p.nombreEmpresa =: datoNombre",Proveedor.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}

}
