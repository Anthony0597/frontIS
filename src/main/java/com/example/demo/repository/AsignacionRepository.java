package com.example.demo.repository;

import com.example.demo.repository.modelo.Asignacion;

public interface AsignacionRepository {
	
	public void insertar(Asignacion asignacion);
	
	public void actualizar(Asignacion asignacion);
	
	public Asignacion seleccionar(Integer id);

}
