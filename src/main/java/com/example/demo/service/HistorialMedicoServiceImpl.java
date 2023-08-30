package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IHistorialMedicoRepository;
import com.example.demo.repository.modelo.HistorialMedico;

@Service

public class HistorialMedicoServiceImpl implements IHistorialMedicoService {

	@Autowired
	private IHistorialMedicoRepository historialMedicoRepository;

	@Override
	public void guardar(HistorialMedico historialMedico) {
		// TODO Auto-generated method stub
		this.historialMedicoRepository.insertar(historialMedico);
	}

	@Override
	public void actualizar(HistorialMedico historialMedico) {
		// TODO Auto-generated method stub
		this.historialMedicoRepository.actualizar(historialMedico);
	}

	@Override
	public HistorialMedico buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.historialMedicoRepository.buscarId(id);
	}

	@Override
	public void eliminarId(Integer id) {
		// TODO Auto-generated method stub
		this.historialMedicoRepository.eliminarId(id);
	}

	@Override
	public List<HistorialMedico> reporteHistorialMedico() {
		// TODO Auto-generated method stub
		return this.historialMedicoRepository.verListaHistorialMedico();
	}
}
