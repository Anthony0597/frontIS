package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Empleado;

public interface IEmpleadoService {

	public void insertar(Empleado empleado);
	public List<Empleado> mostrarListaEmpleados(); 
	
}
