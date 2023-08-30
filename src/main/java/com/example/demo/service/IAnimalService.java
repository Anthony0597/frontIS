package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Animal;

public interface IAnimalService {
	
	
	public void guadar(Animal animal);
	public void actualizar(Animal animal);
	public Animal buscarId(Integer id);
	public void eliminarId(Integer id);
	public List<Animal> reporteAnimales();
	
	public BigDecimal dietaAnimal(BigDecimal peso,BigDecimal factorActvidad);
	
	public Animal reporteEspecie(String nombreEspecie);
	
	public Animal buscarEspecie(String nombreEspecie);
	
	
	

}
