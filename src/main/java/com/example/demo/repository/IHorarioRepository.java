package com.example.demo.repository;

import com.example.demo.repository.modelo.Horarios;

public interface IHorarioRepository {

	public void insertar(Horarios horarios);
	
	public void actualizar(Horarios horarios);
	
	public void eliminar(Horarios horarios);
	
	public Horarios seleccionar(Integer id);
	
}
