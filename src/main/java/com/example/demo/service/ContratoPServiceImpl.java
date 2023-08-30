package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IContratoPRespository;
import com.example.demo.repository.modelo.ContratoProveedores;

@Service
public class ContratoPServiceImpl implements IContratoPService{
	
	@Autowired
	private IContratoPRespository contratoPRespository;

	@Override
	public void agregarContrato(ContratoProveedores cliente) {
		this.contratoPRespository.insertar(cliente);
		
	}

	@Override
	public void actualizar(ContratoProveedores cliente) {
		this.contratoPRespository.actualizar(cliente);		
	}

	@Override
	public ContratoProveedores buscarContratoId(Integer id) {
		return this.contratoPRespository.buscarId(id);
	}

	@Override
	public List<ContratoProveedores> mostrarListaContratos() {
		return this.contratoPRespository.verListaContratos();
	}

}
