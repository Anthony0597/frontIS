package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Cliente;

public interface IClienteService {

	public void agregar(Cliente cliente);
	public void modificar(Cliente cliente);
	public Cliente buscarClienteID(Integer id);
	public void borrarClienteId(Integer id);
	public List<Cliente> mostrarListaClientesVIP(); 
	
}
