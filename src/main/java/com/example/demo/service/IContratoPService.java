package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.ContratoProveedores;

public interface IContratoPService {
	
	public void agregarContrato(ContratoProveedores contratoP1);
	public void actualizar(ContratoProveedores cliente);
	public ContratoProveedores buscarContratoId(Integer id);
	public List<ContratoProveedores> mostrarListaContratos();

}
