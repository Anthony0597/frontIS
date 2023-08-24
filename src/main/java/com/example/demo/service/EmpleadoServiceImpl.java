package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEmpleadoRepository;
import com.example.demo.repository.modelo.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	private IEmpleadoRepository empleadoRepository;
	
	@Override
	public void insertar(Empleado cliente) {
		this.empleadoRepository.insertar(cliente);
		
	}

	@Override
	public List<Empleado> mostrarListaEmpleados() {
		return this.empleadoRepository.verListaEmpleados();
	}

}
