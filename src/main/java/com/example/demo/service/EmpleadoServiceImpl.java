package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.repository.IContratoERepository;
import com.example.demo.repository.modelo.ContratoEmpleados;
import com.example.demo.repository.modelo.Empleado;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	private static final Logger LOG = LoggerFactory.getLogger(EmpleadoServiceImpl.class);
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private IContratoERepository contratoERepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void registrar(Empleado empleado) {
		this.empleadoRepository.insertar(empleado);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(Empleado empleado) {
		this.empleadoRepository.actualizar(empleado);
	}

	@Override
	public Empleado buscar(Integer id) {
		return this.empleadoRepository.seleccionar(id);
	}

	@Override
	public Empleado seleccinarCedula(String cedula) {
		return this.empleadoRepository.seleccinarCedula(cedula);
	}

	@Override
	public void actualizarContrato(Empleado empleado, ContratoEmpleados contratoEmpleados) {
		this.contratoERepository.actualizar(empleado, contratoEmpleados);
		
	}
	
	@Override
    public Boolean autenticar(String correo, String contrasenia) {
		LOG.info("Verificando...");
		Empleado empleado = this.empleadoRepository.buscarCorreo(correo);
        if(empleado == null) {
        	LOG.error("El correo ingresado no existe, verifique bien los datos ingresados");
        	return false;
        } else {
           if(empleado.getContrasenia().equals(contrasenia)) {
        	   LOG.info("Bienvenido/a: "+ empleado.getNombre()+" "+empleado.getApellido());
        	   LOG.info("Iniciando sesion...");
        	   return true;
           }else {
        	   LOG.error("Contraseña incorrecta. Intente de nuevo");
        	   return false;
           }
        }
    }

	@Override
	public List<Empleado> buscarTodos() {
		// TODO Auto-generated method stub
		return this.empleadoRepository.buscar();
	}

	@Override
	public Empleado buscarCorreo(String correo) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.buscarCorreo(correo);
	}

}
