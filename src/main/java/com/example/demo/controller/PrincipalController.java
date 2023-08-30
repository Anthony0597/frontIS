package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicios")
public class PrincipalController { // VISTAS ESTÁTICAS
	
	@GetMapping("/principal")
	public String principal() {// falta el argumento
		return "vistaPrincipal";
	}
	
	@GetMapping("/membresia")
	public String membresia() {// falta el argumento
		return "vistaMembresia";
	}
	
	@GetMapping("/donacion")
	public String donacion() {// falta el argumento
		return "vistaDonacion";
	}
	
	@GetMapping("/informacion")
	public String informacion() {// falta el argumento
		return "vistaInformacionAnimales";
	}
	
	@GetMapping("/evento1") // evento introduccion
	public String eventoIntroduccion() {// falta el argumento
		return "vistaEventoIntroduccion";
	}
	@GetMapping("/evento2") // evento introduccion
	public String eventoLiberacion() {// falta el argumento
		return "vistaEventoLiberacion";
	}
	@GetMapping("/terminosUso") // evento introduccion
	public String terminosUso() {// falta el argumento
		return "vistaTerminosUso";
	}
	@GetMapping("/terminosCondiciones") // evento introduccion
	public String terminosCondiciones() {// falta el argumento
		return "vistaTerminosCondiciones";
	}
	@GetMapping("/politicaPrivacidad") // evento introduccion
	public String politicaPrivacidad() {// falta el argumento
		return "vistaPoliticaPrivacidad";
	}

}
