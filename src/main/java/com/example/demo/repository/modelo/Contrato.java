package com.example.demo.repository.modelo;

import java.time.LocalDateTime;

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

@Table(name = "contrato")
@Entity
public class Contrato {

	@Id
	@SequenceGenerator(name = "seq_contrato",sequenceName = "seq_contrato",allocationSize = 1)
	@GeneratedValue(generator = "seq_contrato",strategy = GenerationType.SEQUENCE)
	@Column(name = "cont_id")
	private Integer id;
	
	@Column(name = "cont_numero")
	private String numero;
	
	@Column(name = "cont_fechaInicio")
	private LocalDateTime fechaInicio;
	
	@Column(name = "cont_fechaFinalizacion")
	private LocalDateTime fechaFinalizacion;
	
	//one to one empleados
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="contr_id_empleado")//
	private Empleado empleado;
	
	//one to one proveedores
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="contr_id_proveedor")//
	private Proveedor proveedor;

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", numero=" + numero + ", fechaInicio=" + fechaInicio + ", fechaFinalizacion="
				+ fechaFinalizacion + "]";
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

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(LocalDateTime fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
}
