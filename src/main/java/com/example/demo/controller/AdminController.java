package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/init")
public class AdminController {
	
	@GetMapping("/Admin")
	public String principal() {
		return "vistaAdmin";
	}
}
