package com.example.demo.repository.modelo;

import java.time.LocalTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "horarios")
public class Horarios {

	@GeneratedValue(generator = "seq_horarios", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_horarios", sequenceName = "seq_horarios", allocationSize = 1)
	@Id
	@Column(name = "hora_id")
	private Integer id;
	
	@Column(name = "hora_entrada")
	private LocalTime horaEntrada;
	
	@Column(name = "hora_salida")
	private LocalTime horaSalida;

	@Column(name = "hora_dias")
	private String diasSemana;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "hora_jornada")
	private Jornada jornada;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hora_id_empleado")
	private Empleado empleado;
	
	@Override
	public String toString() {
		return "Horarios [id=" + id + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", diasSemana="
				+ diasSemana + ", jornada=" + jornada + "]";
	}

	public Jornada getJornada() {
		return jornada;
	}

	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(String diasSemana) {
		this.diasSemana = diasSemana;
	}

	
	
}
