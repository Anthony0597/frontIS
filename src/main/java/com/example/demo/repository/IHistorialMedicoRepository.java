package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.HistorialMedico;

public interface IHistorialMedicoRepository {
	
	public void insertar(HistorialMedico historialMedico);
	public void actualizar(HistorialMedico historialMedico);
	public HistorialMedico buscarId(Integer id);
	public void eliminarId(Integer id);
	public List<HistorialMedico> verListaHistorialMedico();

}
