package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProveedorRepository;
import com.example.demo.repository.modelo.Proveedor;
@Service
public class ProveedorServiceImpl implements IProveedorService{

	@Autowired
	private IProveedorRepository proveedorRepository;
	
	@Override
	public void agregar(Proveedor proveedor) {
		this.proveedorRepository.insertar(proveedor);
	}

	@Override
	public void actualizar(Proveedor proveedor) {
		this.proveedorRepository.actualizar(proveedor);
	}

	@Override
	public Proveedor buscarId(Integer id) {
		return this.proveedorRepository.buscarId(id);
	}

	@Override
	public void eliminarId(Integer id) {
		this.proveedorRepository.eliminarId(id);		
	}

	@Override
	public List<Proveedor> reporteProveedor() {
		// TODO Auto-generated method stub
		return this.proveedorRepository.reporteProveedor();
	}

	

}
