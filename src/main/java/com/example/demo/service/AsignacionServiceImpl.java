package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.AsignacionRepository;
import com.example.demo.repository.modelo.Asignacion;

@Service
public class AsignacionServiceImpl implements AsignacionService {

	@Autowired
	private AsignacionRepository asignacionRepository;

	@Override
	public void guardar(Asignacion asignacion) {
		this.asignacionRepository.insertar(asignacion);
	}

	@Override
	public void actualizar(Asignacion asignacion) {
		this.asignacionRepository.actualizar(asignacion);
	}

	@Override
	public Asignacion buscar(Integer id) {
		return this.asignacionRepository.seleccionar(id);
	}

}
