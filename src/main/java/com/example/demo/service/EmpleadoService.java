package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.ContratoEmpleados;
import com.example.demo.repository.modelo.Empleado;

public interface EmpleadoService {

	public void registrar(Empleado empleado);
	public Empleado seleccinarCedula(String cedula);
	public void actualizar(Empleado empleado);
	public void actualizarContrato(Empleado empleado, ContratoEmpleados contratoEmpleados);
	public Empleado buscar(Integer id);
	public List<Empleado> buscarTodos();
	public Boolean autenticar(String correo, String contrasenia);
}
