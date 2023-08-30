package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.repository.IContratoERepository;
import com.example.demo.repository.modelo.ContratoEmpleados;
import com.example.demo.repository.modelo.Empleado;

import jakarta.transaction.Transactional;

@Service
public class ContratoEServiceImpl implements IContratoEService {

	@Autowired
	private IContratoERepository contratoRepository;

	@Autowired
	private EmpleadoService empleadoService;

	@Override
	public void agregarContrato(ContratoEmpleados contrato) {
		this.contratoRepository.insertar(contrato);

	}

	@Override
	public void actualizar(String cedula, ContratoEmpleados nuevoContrato) {
		Empleado empleado = empleadoService.seleccinarCedula(cedula);

		if (empleado != null) {
			ContratoEmpleados contratoActual = contratoRepository.buscarContratoActivoEmpleado(empleado);
			if (contratoActual != null) {
				contratoActual.setEstado(false);
				contratoRepository.actualizar(empleado, contratoActual);
			}

			nuevoContrato.setEmpleado(empleado);
			nuevoContrato.setEstado(true);

			contratoRepository.insertar(nuevoContrato);
		} else {
			System.out.println("No exite el empleado");
		}
	}

	@Override
	public ContratoEmpleados buscarContratoId(Integer id) {
		return this.contratoRepository.buscarId(id);
	}

	@Override
	public List<ContratoEmpleados> mostrarListaContratos() {
		return this.contratoRepository.verListaContratos();
	}

}
