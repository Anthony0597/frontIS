package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Cliente;

public interface IClienteRepository {
	
	public void insertar(Cliente cliente);
	public void actualizar(Cliente cliente);
	public Cliente buscarId(Integer id);
	public void eliminarId(Integer id);
	public List<Cliente> verListaClientesVIP(); 

	public Cliente buscarPorNumeroCedula(String cedula);
	// BUSCAR POR c
	public Cliente buscarCorreo(String correo);



}
