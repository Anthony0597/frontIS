package com.example.demo.repository.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name = "historialmedico")
public class HistorialMedico {

	@GeneratedValue(generator = "seq_historialmedico", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_historialmedico", sequenceName = "seq_historialmedico", allocationSize = 1)

	@Id
	@Column(name = "hist_id")
	private Integer id;
	@Column(name = "hist_fechaConsulta")
	private LocalDate fechaConsulta;
	@Column(name = "hist_fechaProximaCita")
	private LocalDate fechaProximaCita;
	@Column(name = "hist_numeroHistorial")
	private String  numeroHistorial;
	@Column(name = "hist_veterinario")
	private String veterinario;
	@Column(name = "hist_detalle")
	private String detalle;
	
	
	@Column(name = "hist_codigoAnimal")
	private String codigoAnimal;
	
	//relacion
	//(fetch = FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name="animal_id")
	private Animal animal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(LocalDate fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public LocalDate getFechaProximaCita() {
		return fechaProximaCita;
	}

	public void setFechaProximaCita(LocalDate fechaProximaCita) {
		this.fechaProximaCita = fechaProximaCita;
	}

	public String getNumeroHistorial() {
		return numeroHistorial;
	}

	public void setNumeroHistorial(String numeroHistorial) {
		this.numeroHistorial = numeroHistorial;
	}

	public String getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(String veterinario) {
		this.veterinario = veterinario;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getCodigoAnimal() {
		return codigoAnimal;
	}

	public void setCodigoAnimal(String codigoAnimal) {
		this.codigoAnimal = codigoAnimal;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public String toString() {
		return "HistorialMedico [id=" + id + ", fechaConsulta=" + fechaConsulta + ", fechaProximaCita="
				+ fechaProximaCita + ", numeroHistorial=" + numeroHistorial + ", veterinario=" + veterinario
				+ ", detalle=" + detalle + ", codigoAnimal=" + codigoAnimal + ", animal=" + animal + "]";
	}


	

}
