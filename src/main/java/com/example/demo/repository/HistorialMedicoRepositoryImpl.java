package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Animal;
import com.example.demo.repository.modelo.HistorialMedico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HistorialMedicoRepositoryImpl implements IHistorialMedicoRepository {
	@PersistenceContext 
	private EntityManager entityManager;

	@Override
	public void insertar(HistorialMedico historialMedico) {
		// TODO Auto-generated method stub
		this.entityManager.merge(historialMedico);
	}

	@Override
	public void actualizar(HistorialMedico historialMedico) {
		// TODO Auto-generated method stub
		this.entityManager.merge(historialMedico);
	}

	@Override
	public HistorialMedico buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(HistorialMedico.class, id);
	}

	@Override
	public void eliminarId(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(id);
	}

	@Override
	public List<HistorialMedico> verListaHistorialMedico() {
		// TODO Auto-generated method stub
		TypedQuery<HistorialMedico> myQuery = this.entityManager.createQuery(
				"SELECT h FROM HistorialMedico h "
				,HistorialMedico.class);
		return myQuery.getResultList();
	}

}
