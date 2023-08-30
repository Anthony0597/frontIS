package com.example.demo.repository.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {

	@Id
	@SequenceGenerator(name = "seq_proveedor", sequenceName = "seq_proveedor", allocationSize = 1)
	@GeneratedValue(generator = "seq_proveedor", strategy = GenerationType.SEQUENCE)
	@Column(name = "prov_id")
	private Integer id;

	@Column(name = "prov_nombre_empresa")
	private String nombreEmpresa;

	@Column(name = "prov_telefono")
	private String telefono;

	@Column(name = "prov_correo_electronico")
	private String correoElectronico;

	@Column(name = "prov_tiempo_entrega")
	private int tiempoEntrega;
	
	//relacion con producto
	@OneToMany(mappedBy = "proveedor",cascade = CascadeType.ALL)
	private List<Producto> listaProductos=new ArrayList<>();

	// relacion con contrato
	@OneToOne(mappedBy = "proveedor", cascade = CascadeType.ALL)
	private ContratoProveedores contrato_proveedores= new ContratoProveedores();

	// set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public int getTiempoEntrega() {
		return tiempoEntrega;
	}

	public void setTiempoEntrega(int tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public ContratoProveedores getContrato_proveedores() {
		return contrato_proveedores;
	}

	public void setContrato_proveedores(ContratoProveedores contrato_proveedores) {
		this.contrato_proveedores = contrato_proveedores;
	}

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombreEmpresa=" + nombreEmpresa + ", telefono=" + telefono
				+ ", correoElectronico=" + correoElectronico + ", tiempoEntrega=" + tiempoEntrega + "]";
	}
	
}
