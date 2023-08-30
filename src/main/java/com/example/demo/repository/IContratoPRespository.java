package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.ContratoProveedores;

public interface IContratoPRespository {

	public void insertar(ContratoProveedores cliente);
	public void actualizar(ContratoProveedores cliente);
	public ContratoProveedores buscarId(Integer id);
	public List<ContratoProveedores> verListaContratos();

}