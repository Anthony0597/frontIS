package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void actualizar(Cliente cliente) {
		this.entityManager.merge(cliente);
		
	}

	@Override
	public Cliente buscarId(Integer id) {
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	public void eliminarId(Integer id) {
		this.entityManager.remove(id);
		
	}

	@Override
	public List<Cliente> verListaClientesVIP() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c",Cliente.class);
		return myQuery.getResultList();
	}

	@Override
	public Cliente buscarPorNumeroCedula(String cedula) {
		TypedQuery<Cliente> query = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.cedula = :datoCedula", Cliente.class);
        query.setParameter("datoCedula", cedula);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Retorna null si no se encuentra ningún cliente
        }
	}
	
	@Override
	public void insertar(Cliente cliente) {
		this.entityManager.persist(cliente);
		
	}
	// buscar correo
		@Override
		public Cliente buscarCorreo(String correo) {
			TypedQuery<Cliente> query = this.entityManager
					.createQuery("SELECT c FROM Cliente c WHERE c.correo = :datoCorreo", Cliente.class);
			query.setParameter("datoCorreo", correo);
			try {
				return query.getSingleResult();
			} catch (Exception e) {
				System.err.println("No se encontro el correo");
				return null;
			}
		}
}
