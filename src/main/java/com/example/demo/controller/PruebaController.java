package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/servi")
public class PruebaController {
	private boolean mostrarSeccion = false;

    @GetMapping("/mostrar-ocultar")
    public String mostrarOcultar(Model model) {
        model.addAttribute("mostrarSeccion", mostrarSeccion);
        return "VistaPrueba";
    }

    @GetMapping("/mostrar-seccion")
    public String mostrarSeccion() {
        mostrarSeccion = true;
        return "redirect:/servi/mostrar-ocultar";
    }

    @GetMapping("/ocultar-seccion")
    public String ocultarSeccion() {
        mostrarSeccion = false;
        return "redirect:/servi/mostrar-ocultar";
    }
	

}
