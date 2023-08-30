package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.HistorialMedico;

public interface IHistorialMedicoService {
	
	public void guardar(HistorialMedico historialMedico);
	public void actualizar(HistorialMedico historialMedico);
	public HistorialMedico buscarId(Integer id);
	public void eliminarId(Integer id);
	public List<HistorialMedico> reporteHistorialMedico();

}
