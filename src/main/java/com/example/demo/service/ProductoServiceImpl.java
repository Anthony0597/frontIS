package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProductoRepository;
import com.example.demo.repository.modelo.Producto;
@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository productoRepository;
	
	@Override
	public void agregar(Producto producto) {
		this.productoRepository.insertar(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		this.productoRepository.actualizar(producto);
		
	}

	@Override
	public Producto buscarId(String codigoId) {
		// TODO Auto-generated method stub
		return this.productoRepository.buscarId(codigoId);
	}

	@Override
	public void borrarId(String codigoId) {
		this.productoRepository.eliminarId(codigoId);
		
	}

	@Override
	public List<Producto> buscar() {
		// TODO Auto-generated method stub
		return this.productoRepository.buscar();
	}

}
