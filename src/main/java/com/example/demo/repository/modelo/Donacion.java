package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "donaciones")
@Entity
public class Donacion {
	
	@Id
	@SequenceGenerator(name = "seq_donaciones",sequenceName = "seq_donaciones",allocationSize = 1)
	@GeneratedValue(generator = "seq_donaciones",strategy = GenerationType.SEQUENCE)
	@Column(name = "dona_id")
	private Integer id;
	
	@Column(name = "dona_donante")
	private String donante;
	
	@Column(name = "dona_monto")
	private BigDecimal monto ;
	//getters y setters
	
	@Override
	public String toString() {
		return "\n[id=" + id + ", donante=" + donante + ", monto=" + monto + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDonante() {
		return donante;
	}

	public void setDonante(String donante) {
		this.donante = donante;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	
}
