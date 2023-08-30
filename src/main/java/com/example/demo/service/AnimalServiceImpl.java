package com.example.demo.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IAnimalRepository;
import com.example.demo.repository.modelo.Animal;

@Service
public class AnimalServiceImpl implements IAnimalService {
	
	@Autowired
	private IAnimalRepository animalRepository;

	@Override
	public void guadar(Animal animal) {
		this.animalRepository.insertar(animal);
	}

	@Override
	public void actualizar(Animal animal) {
		this.animalRepository.actualizar(animal);
	}

	@Override
	public Animal buscarId(Integer id) {
		return this.animalRepository.buscarId(id);
	}

	@Override
	public void eliminarId(Integer id) {
		this.animalRepository.eliminarId(id);
	}

	@Override
	public List<Animal> reporteAnimales() {
		return this.animalRepository.verListaAnimales();
	}

	@Override
	public BigDecimal dietaAnimal(BigDecimal peso, BigDecimal factorActvidad) {
		/*BigDecimal exponente=factorActvidad.multiply(new BigDecimal(0.75));
		BigDecimal caloricoDiario= peso.pow(exponente.intValueExact(),MathContext.DECIMAL128);
		return caloricoDiario;*/
		return null;
		
	}

	@Override
	public Animal reporteEspecie(String nombreEspecie) {
		return this.animalRepository.buscarEspecie(nombreEspecie);
	}

	@Override
	public Animal buscarEspecie(String nombreEspecie) {
		return this.animalRepository.buscarEspecie(nombreEspecie);
	}

	
	
	
	

}
