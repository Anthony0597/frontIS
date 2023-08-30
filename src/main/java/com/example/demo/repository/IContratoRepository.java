package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Contrato;

public interface IContratoRepository {

	public void insertar(Contrato cliente);
	public void actualizar(Contrato cliente);
	public Contrato buscarId(Integer id);
	public void eliminarId(Integer id);
	public List<Contrato> verListaContratosEmpleados();
	public List<Contrato> verListaContratosProveedores();
	
}
