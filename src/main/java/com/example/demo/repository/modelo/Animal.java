package com.example.demo.repository.modelo;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "animal")
public class Animal {

	@GeneratedValue(generator = "seq_animal", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_animal", sequenceName = "seq_animal", allocationSize = 1)

	@Id
	@Column(name = "anim_id")
	private Integer id;
	@Column(name = "anim_nombreCientifico")
	private String nombreCientifico;
	@Column(name = "anim_nombreComun")
	private String nombreComun;
	@Column(name = "anim_peso")
	private Double peso;
	@Column(name = "anim_dieta")
	private String dieta;
	@Column(name = "anim_edad")
	private String edad;
	@Column(name = "anim_estado")
	private String estado;
	@Column(name = "anim_codigoRegistro")
	private String codigoRegistro;
	@Column(name = "anim_comportamiento")
	private String comportamineto;

	@OneToMany(mappedBy = "animal",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<HistorialMedico> historialMedico;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	public String getNombreComun() {
		return nombreComun;
	}

	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getDieta() {
		return dieta;
	}

	public void setDieta(String dieta) {
		this.dieta = dieta;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(String codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public List<HistorialMedico> getHistorialMedico() {
		return historialMedico;
	}

	public void setHistorialMedico(List<HistorialMedico> historialMedico) {
		this.historialMedico = historialMedico;
	}

	public String getComportamineto() {
		return comportamineto;
	}

	public void setComportamineto(String comportamineto) {
		this.comportamineto = comportamineto;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nombreCientifico=" + nombreCientifico + ", nombreComun=" + nombreComun
				+ ", peso=" + peso + ", dieta=" + dieta + ", edad=" + edad + ", estado=" + estado + ", codigoRegistro="
				+ codigoRegistro + ", comportamineto=" + comportamineto + "]";
	}

}
