package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Empleado;
import com.example.demo.repository.modelo.TipoCargo;
import com.example.demo.service.EmpleadoService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private final AdminController admin;
	@Autowired
	public UsuarioController(AdminController admin) {
		this.admin=admin;
	}

	
	@Autowired
	private EmpleadoService empService;
	private  Empleado emp = new Empleado();
	
	
	
	@GetMapping("/ingreso")
	public String ingreso(Empleado emp) {
		this.emp=emp;
		return "vistaIngresoU";
		
	}
	
	@GetMapping("/empleado")
	public String usuario(Empleado emp, Model model) {
		//empService.autenticar(emp.getCorreo(), emp.getContrasenia());
		Empleado temp=empService.buscarCorreo(emp.getCorreo());
		model.addAttribute("usuario", temp);
		if(temp.getTipoCargo().equals(TipoCargo.ADMINISTRADOR)) {
			admin.principal(model);
			return "redirect:/servicio/admin";
		}else {
			return "redirect:/servis/empleado";
		}
		
	}
}
