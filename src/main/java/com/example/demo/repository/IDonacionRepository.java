package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Donacion;

public interface IDonacionRepository {

	public void agregarDonacion(Donacion donacion);
    public Donacion obtenerDonacionPorId(int id);
    public List<Donacion> obtenerTodasLasDonaciones();
	public BigDecimal obtenerMontoTotalDonaciones();
}
