package com.example.demo.repository.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {
	
	@Id
	@SequenceGenerator(name = "seq_proveedor",sequenceName = "seq_proveedor",allocationSize = 1)
	@GeneratedValue(generator = "seq_proveedor",strategy = GenerationType.SEQUENCE)
	@Column(name = "prove_id")
	private Integer id;
	
	//atributos
	
	//relacion con contrato
	@OneToOne(mappedBy = "proveedor", cascade = CascadeType.ALL)
	private Contrato contrato;

	
}
