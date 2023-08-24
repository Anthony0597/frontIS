package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Empleado;

public interface IEmpleadoRepository{

	public void insertar(Empleado cliente);
	public List<Empleado> verListaEmpleados(); 
	
}
