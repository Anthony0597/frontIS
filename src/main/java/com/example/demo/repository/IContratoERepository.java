package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.ContratoEmpleados;
import com.example.demo.repository.modelo.Empleado;

public interface IContratoERepository {

	public ContratoEmpleados buscarContratoActivoEmpleado(Empleado empleado );
	public void insertar(ContratoEmpleados cliente);
	public void actualizar(Empleado empleado, ContratoEmpleados contrato);
	public ContratoEmpleados buscarId(Integer id);
	public List<ContratoEmpleados> verListaContratos();

	
}
