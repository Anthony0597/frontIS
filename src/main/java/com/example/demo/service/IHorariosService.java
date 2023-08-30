package com.example.demo.service;

import com.example.demo.repository.modelo.Horarios;

public interface IHorariosService {

public void asignar(Horarios horarios);
	
	public void cambiar(Horarios horarios);
	
	public void borrar(Horarios horarios);
	
	public Horarios buscar(Integer id);
	
}
