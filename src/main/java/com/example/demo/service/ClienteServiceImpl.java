package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	public void agregar(Cliente cliente) {
		this.clienteRepository.insertar(cliente);
		
	}

	@Override
	public void modificar(Cliente cliente) {
		this.clienteRepository.actualizar(cliente);
		
	}

	@Override
	public Cliente buscarClienteID(Integer id) {
		return this.clienteRepository.buscarId(id);
	}

	@Override
	public void borrarClienteId(Integer id) {
		this.clienteRepository.eliminarId(id);
	}

	@Override
	public List<Cliente> mostrarListaClientesVIP() {
		return this.clienteRepository.verListaClientesVIP();
	}

}
