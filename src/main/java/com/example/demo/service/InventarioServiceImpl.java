package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.InventarioRepository;
import com.example.demo.repository.modelo.Inventario;

@Service
public class InventarioServiceImpl implements InventarioService{
	
	@Autowired
	private InventarioRepository inventarioRepository;

	@Override
	public void agregar(Inventario inventario) {
		this.inventarioRepository.insertar(inventario);
		
	}
	@Override
	public void actualizar(Inventario inventario) {
		this.inventarioRepository.actualizar(inventario);
		
	}

}
