package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Donacion;
import com.example.demo.service.DonacionServiceImpl;

@Controller
@RequestMapping("/donaciones")
public class DonacionController {
	
	@Autowired
	private DonacionServiceImpl donacionServiceImpl;
	
	@GetMapping("/donacion")
	public String donacion(Donacion donacion) {// falta el argumento
		return "vistaDonacion";
	}
	@PostMapping("insertarDonacion")
	public String insertarDonacion(Donacion donacion, Model model) {
		if(donacion.getDonante()==null ) {
			donacion.setDonante("Anónimo");
		}
		this.donacionServiceImpl.guardarDonacion(donacion);
		model.addAttribute("showWarning", true);
		return "vistaDonacion";
	}
	
}
