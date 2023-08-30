package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "contrato_empleados")
public class ContratoEmpleados {

	@Id
	@SequenceGenerator(name = "seq_contratoE",sequenceName = "seq_contratoE",allocationSize = 1)
	@GeneratedValue(generator = "seq_contratoE",strategy = GenerationType.SEQUENCE)
	@Column(name = "cont_id")
	private Integer id;
	
	@Column(name = "cont_numero")
	private String numero;
	
	@Column(name = "cont_fechaInicio")
	private LocalDate fechaInicio;
	
	@Column(name = "cont_fechaFinalizacion")
	private LocalDate fechaFinalizacion;
	
	@Column(name = "cont_sueldo")
	private BigDecimal sueldo;
	
	@Column(name = "cont_estado")
	private boolean estado;	
	
	//many to one empleados
	@ManyToOne
	@JoinColumn(name="cont_id_empleado")//
	private Empleado empleado;

	@Override
	public String toString() {
		return "ContratoEmpleados [id=" + id + ", numero=" + numero + ", fechaInicio=" + fechaInicio
				+ ", fechaFinalizacion=" + fechaFinalizacion + ", sueldo=" + sueldo + ", estado=" + estado + "]";
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

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
