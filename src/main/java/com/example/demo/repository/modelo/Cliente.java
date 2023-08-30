package com.example.demo.repository.modelo;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "cliente_VIP")
@Entity
public class Cliente {
	
	@Id
	@SequenceGenerator(name = "seq_cliente",sequenceName = "seq_cliente",allocationSize = 1)
	@GeneratedValue(generator = "seq_cliente",strategy = GenerationType.SEQUENCE)
	@Column(name = "clte_id")
	private Integer id;
	
	@Column(name = "clte_nombre")
	private String nombre;
	
	@Column(name = "clte_apellido")
	private String apellido;
	
	@Column(name = "clte_cedula")
	private String cedula;
	
	@Column(name = "clte_fechaNacimiento")
	private LocalDateTime fechaN;

	@Column(name = "clte_correo")
	private String correo;
	

	@Column(name = "clte_telefono")
	private String telefono;

	@Column(name = "clie_contrasenia")
	private String contrasenia;
	
//getter y setters

@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", fechaN=" + fechaN + ", correo=" + correo + ", telefono=" + telefono + ", contrasenia="
				+ contrasenia + "]";
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

	public LocalDateTime getFechaN() {
		return fechaN;
	}

	public void setFechaN(LocalDateTime fechaN) {
		this.fechaN = fechaN;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
