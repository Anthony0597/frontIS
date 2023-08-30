package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.ContratoEmpleados;
import com.example.demo.repository.modelo.Empleado;

public interface IContratoEService {

	public void agregarContrato(ContratoEmpleados cliente);
	public void actualizar(String cedula, ContratoEmpleados cliente);
	public ContratoEmpleados buscarContratoId(Integer id);
	public List<ContratoEmpleados> mostrarListaContratos();
	
	
}
