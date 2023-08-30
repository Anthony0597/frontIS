package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Donacion;

public interface IDonacionService {

	public void guardarDonacion(Donacion donacion);
    public Donacion encontrarDonacionPorId(int id);
    public List<Donacion> listaDonaciones();
	public BigDecimal montoTotalDonaciones();
	
}
