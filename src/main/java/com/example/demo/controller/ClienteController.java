package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.service.IClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/registro")
	public String registro(Cliente cliente) {
		return "vistaRegistro";
	}
	@PostMapping("insertarCliente")
	public String insertarCliente(Cliente cliente) {
		this.clienteService.agregar(cliente);
		return "redirect:/clientes/registro";
	}
	
	@GetMapping("/ingreso")
	public String ingreso(Cliente cliente) {// falta el argumento
		return "vistaIngreso";
	}
	@GetMapping("/buscarPorCorreo")
	public String buscarPorCedula(Cliente cliente, Model model) {
		Cliente cliente2 = this.clienteService.buscarClienteID(cliente.getId()); // cambiar por correo
		model.addAttribute("cliente", cliente2);
		return "vistaPrincipal"; // cambiar la vista donde se dirige
	}
	
	@GetMapping("usuario")
	public String usuario(Cliente cliente, Model model) {
		if(this.clienteService.autenticar(cliente.getCorreo(), cliente.getContrasenia())) {
			Cliente cliente2 = this.clienteService.buscarClienteCorreo(cliente.getCorreo());
			model.addAttribute("cliente", cliente2);
			return "vistaUsuario";
		}else {
			model.addAttribute("showWarning", true);
			return "vistaIngreso";
		}
	}
	
}
