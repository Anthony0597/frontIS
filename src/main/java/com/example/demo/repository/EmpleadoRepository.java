package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Empleado;

public interface EmpleadoRepository {
	
	public void insertar(Empleado empleado);
	public void actualizar(Empleado empleado);
	public Empleado seleccinarCedula(String cedula);
	public Empleado seleccionar(Integer id);
	public Empleado buscarCorreo(String correo);
	public List<Empleado> buscar();
	

}
