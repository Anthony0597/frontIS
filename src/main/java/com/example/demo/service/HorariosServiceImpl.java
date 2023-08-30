package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IHorarioRepository;
import com.example.demo.repository.modelo.Horarios;

@Service
public class HorariosServiceImpl implements IHorariosService{

	@Autowired
	private IHorarioRepository horarioRepository;
	
	@Override
	public void asignar(Horarios horarios) {
		this.horarioRepository.insertar(horarios);
		
	}

	@Override
	public void cambiar(Horarios horarios) {
		this.horarioRepository.actualizar(horarios);
		
	}

	@Override
	public void borrar(Horarios horarios) {
		this.horarioRepository.eliminar(horarios);
		
	}

	@Override
	public Horarios buscar(Integer id) {
		return this.horarioRepository.seleccionar(id);
	}

}
