package com.example.demo.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@Column(name = "prod_codigo_id")
	private String codigoId;
	
	@Column(name = "prod_nombre")
	private String nombre;
	
	@Column(name = "prod_descripcion")
	private String descripcion;
	
	@Column(name = "prod_stock")
	private int stock;

	//relacion proveedor
	@ManyToOne
	@JoinColumn(name="prod_id_proveedor")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name="prod_inventario")
	private Inventario inventario;

	//Set y Get
	public String getCodigoId() {
		return codigoId;
	}

	public void setCodigoId(String codigoId) {
		this.codigoId = codigoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Producto [codigoId=" + codigoId + ", nombre=" + nombre + ", descripcion=" + descripcion + ", stock="
				+ stock + "]";
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}	
	
}