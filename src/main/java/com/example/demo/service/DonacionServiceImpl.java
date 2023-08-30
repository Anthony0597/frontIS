package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IDonacionRepository;
import com.example.demo.repository.modelo.Donacion;

@Service
public class DonacionServiceImpl implements IDonacionService{

	@Autowired
	private IDonacionRepository donacionRepository;
	
	@Override
	public void guardarDonacion(Donacion donacion) {
		this.donacionRepository.agregarDonacion(donacion);
		
	}

	@Override
	public Donacion encontrarDonacionPorId(int id) {
		return this.donacionRepository.obtenerDonacionPorId(id);
	}

	@Override
	public List<Donacion> listaDonaciones() {
		return this.donacionRepository.obtenerTodasLasDonaciones();
	}

	@Override
	public BigDecimal montoTotalDonaciones() {
		return this.donacionRepository.obtenerMontoTotalDonaciones();
	}

}
