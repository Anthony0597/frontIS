package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IContratoRepository;
import com.example.demo.repository.modelo.Contrato;

@Service
public class ContratoServiceImpl implements IContratoService{

	@Autowired
	private IContratoRepository contratoRepository;
	
	@Override
	public void agregarContrato(Contrato cliente) {
		this.contratoRepository.insertar(cliente);
		
	}

	@Override
	public void actualizar(Contrato cliente) {
		this.contratoRepository.actualizar(cliente);
	}

	@Override
	public Contrato buscarContratoId(Integer id) {
		return this.contratoRepository.buscarId(id);
	}

	@Override
	public void borrarContratoId(Integer id) {
		this.contratoRepository.eliminarId(id);
	}

	@Override
	public List<Contrato> mostrarListaContratosEmpleados() {
		return this.contratoRepository.verListaContratosEmpleados();
	}

	@Override
	public List<Contrato> mostrarListaContratosProveedores() {
		return this.contratoRepository.verListaContratosProveedores();
	}

	
	
}
