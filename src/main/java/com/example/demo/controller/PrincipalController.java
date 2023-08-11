package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicios")
public class PrincipalController {
	
	@GetMapping("/principal")
	public String principal() {// falta el argumento
		return "vistaPrincipal";
	}
	
	@GetMapping("/ingreso")
	public String ingreso() {// falta el argumento
		return "vistaIngreso";
	}
	
	@GetMapping("/registro")
	public String registro() {// falta el argumento
		return "vistaRegistro";
	}
	
	@GetMapping("/suscripcion")
	public String suscripcion() {// falta el argumento
		return "vistaSuscripcion";
	}
	
	@GetMapping("/donacion")
	public String donacion() {// falta el argumento
		return "vistaDonacion";
	}
	
	@GetMapping("/informacion")
	public String informacion() {// falta el argumento
		return "vistaInformacion";
	}
	
	@GetMapping("/reservas")
	public String reservas() {// falta el argumento
		return "vistaReservas";
	}

}
