package com.example.demo.repository;

import com.example.demo.repository.modelo.Producto;

public interface IProductoRepository {
	
	public void insertar(Producto producto);
	public void actualizar(Producto producto);
	public Producto buscarId(String codigoId);
	public void eliminarId(String codigoId);

}
