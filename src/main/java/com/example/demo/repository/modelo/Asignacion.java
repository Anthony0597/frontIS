package com.example.demo.repository.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignacion")
public class Asignacion {
	
	@GeneratedValue(generator = "seq_asignacion", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_asignacion", sequenceName = "seq_asignacion", allocationSize = 1)
	@Id
	@Column(name = "asig_id")
	private Integer id;
	
	@Column(name = "asig_detalle")
	private String detalle;
	
	@Column(name = "asig_estado")
	private Boolean estado;

	@ManyToOne
	@JoinColumn(name = "asig_id_empleado")
	private Empleado empleado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Asignacion [id=" + id + ", detalle=" + detalle + ", estado=" + estado + "]";
	}
	
	
	
}
