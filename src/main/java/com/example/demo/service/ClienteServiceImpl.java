package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	private static final Logger LOG = LoggerFactory.getLogger(ClienteServiceImpl.class);
	
	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	public void agregar(Cliente cliente) {
		 Cliente clienteExistente = clienteRepository.buscarPorNumeroCedula(cliente.getCedula());
	        if (clienteExistente == null) {
	        	this.clienteRepository.insertar(cliente);   
	        }else {
	        	 LOG.error("Ya existe un cliente con este número de cédula.");
	        }
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
	@Override
	public Boolean autenticar(String correo, String pass) {
		System.out.println("Verificando...");
		Cliente cliente = this.clienteRepository.buscarCorreo(correo);
		if (cliente == null) {
			System.out.println("El correo no existe, intente de  nuevo.");
			System.out.println("Si no tiene cuenta registrese :) ");
			return false;
		} else {
			if (cliente.getContrasenia().equals(pass)) {
				System.out.println("Bienvenido/a: "+ cliente.getNombre()+" "+cliente.getApellido());
				System.out.println("Iniciando sesion...");
				return true;
			} else {
				System.out.println("Contraseña incorrecta. Intente de nuevo");
				return false;
			}
		}
	}
	
}
