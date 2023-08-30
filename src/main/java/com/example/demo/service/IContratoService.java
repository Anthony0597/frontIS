package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Contrato;

public interface IContratoService {

	public void agregarContrato(Contrato cliente);
	public void actualizar(Contrato cliente);
	public Contrato buscarContratoId(Integer id);
	public void borrarContratoId(Integer id);
	public List<Contrato> mostrarListaContratosEmpleados();
	public List<Contrato> mostrarListaContratosProveedores();
	
	
}
