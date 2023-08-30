package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Animal;

public interface IAnimalRepository {
	
	public void insertar(Animal animal);
	public void actualizar(Animal animal);
	public Animal buscarId(Integer id);
	public void eliminarId(Integer id);
	public List<Animal> verListaAnimales();
	
	public Animal buscarEspecie(String nombreEspecie);

}
