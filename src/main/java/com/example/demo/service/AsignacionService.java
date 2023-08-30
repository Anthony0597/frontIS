package com.example.demo.service;

import com.example.demo.repository.modelo.Asignacion;

public interface AsignacionService {
	
	public void guardar(Asignacion asignacion);
	
	public void actualizar(Asignacion asignacion);
	
	public Asignacion buscar(Integer id);

}
