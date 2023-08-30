package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "contrato_proveedores")
@Entity
public class ContratoProveedores {

	@Id
	@SequenceGenerator(name = "seq_contratoP",sequenceName = "seq_contratoP",allocationSize = 1)
	@GeneratedValue(generator = "seq_contratoP",strategy = GenerationType.SEQUENCE)
	@Column(name = "cont_id")
	private Integer id;
	
	@Column(name = "cont_numero")
	private String numero;
	
	@Column(name = "cont_fechaInicio")
	private LocalDate fechaInicio;
	
	@Column(name = "cont_fechaFinalizacion")
	private LocalDate fechaFinalizacion;
	
	//one to one proveedores
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cont_id_proveedor")//
	private Proveedor proveedor;

	@Override
	public String toString() {
		return "ContratoProveedores [id=" + id + ", numero=" + numero + ", fechaInicio=" + fechaInicio
				+ ", fechaFinalizacion=" + fechaFinalizacion + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
}
