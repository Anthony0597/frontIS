package com.example.demo.repository.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {

	@GeneratedValue(generator = "seq_empleado", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_empleado", sequenceName = "seq_empleado", allocationSize = 1)
	@Id
	@Column(name = "empl_id")
	private Integer id;

	@Column(name = "empl_nombre")
	private String nombre;

	@Column(name = "empl_apellido")
	private String apellido;

	@Column(name = "empl_cedula")
	private String cedula;

	@Column(name = "empl_fecha_nacimiento")
	private LocalDate fechaNacimiento;

	@Column(name = "empl_correo")
	private String correo;

	@Column(name = "empl_telefono")
	private String telefono;

	@Column(name = "empl_contrasenia")
	private String contrasenia;

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "empl_cargo_tipo")
	private TipoCargo tipoCargo;

	@OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
	private List<ContratoEmpleados> contrato_empleados=new ArrayList<>();

	@OneToOne(mappedBy = "empleado", cascade = CascadeType.ALL)
	private Horarios horarios;

	@OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Asignacion> asignaciones=new ArrayList<>();

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", fechaNacimiento=" + fechaNacimiento + ", email=" + correo + ", telefono=" + telefono
				+ ", tipoCargo=" + tipoCargo + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public TipoCargo getTipoCargo() {
		return tipoCargo;
	}

	public void setTipoCargo(TipoCargo tipoCargo) {
		this.tipoCargo = tipoCargo;
	}

	public List<ContratoEmpleados> getContrato_empleados() {
		return contrato_empleados;
	}

	public void setContrato_empleados(List<ContratoEmpleados> contrato_empleados) {
		this.contrato_empleados = contrato_empleados;
	}

	public Horarios getHorarios() {
		return horarios;
	}

	public void setHorarios(Horarios horarios) {
		this.horarios = horarios;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

}
