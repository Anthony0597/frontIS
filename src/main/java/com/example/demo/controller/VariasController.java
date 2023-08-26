package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prueba")
public class VariasController {
	private Map<String, Boolean> seccionesVisibles = new HashMap<>();
	
	@GetMapping("/mostrar-ocultar")
	public String mostrarOcultar(Model model) {
		/*seccionesVisibles.put("seccion2", true);
        seccionesVisibles.put("seccion3", true);*/
        
		model.addAttribute("seccionesVisibles", seccionesVisibles);
		return "VistaVariasSecciones";
	}

	@GetMapping("/mostrar-seccion/{seccion}")
	public String mostrarSeccion(@PathVariable String seccion) {
		seccionesVisibles.put(seccion, true);
		
		return "redirect:/prueba/mostrar-ocultar";
	}

	@GetMapping("/ocultar-seccion/{seccion}")
	public String ocultarSeccion(@PathVariable String seccion) {
		seccionesVisibles.put(seccion, false);
		return "redirect:/prueba/mostrar-ocultar";
	}
}
