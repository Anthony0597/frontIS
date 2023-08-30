package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Animal;
import com.example.demo.repository.modelo.Asignacion;
import com.example.demo.repository.modelo.ContratoEmpleados;
import com.example.demo.repository.modelo.Empleado;
import com.example.demo.repository.modelo.HistorialMedico;
import com.example.demo.repository.modelo.Proveedor;
import com.example.demo.service.AnimalServiceImpl;
import com.example.demo.service.AsignacionServiceImpl;
import com.example.demo.service.EmpleadoService;
import com.example.demo.service.HistorialMedicoServiceImpl;
import com.example.demo.service.IContratoEService;

@Controller
@RequestMapping("/servicio")
public class AdminController {
	
	@Autowired
	private EmpleadoService empService;
	@Autowired
	private IContratoEService contEService;
	@Autowired
	private AsignacionServiceImpl asigService;
	@Autowired
	private AnimalServiceImpl aniService;
	@Autowired
	private HistorialMedicoServiceImpl histoService;
	
	private static Map<String, Boolean> secciones = new HashMap<>();
	private  Empleado emp = new Empleado();
	private  Animal ani = new Animal();
	private  Proveedor prov = new Proveedor();
	private Asignacion asig = new Asignacion();
	private ContratoEmpleados contE = new ContratoEmpleados();
	private HistorialMedico histo = new HistorialMedico();
	private List<Empleado> empleados ;
	private List<Animal> animales ;
	
	public AdminController() {
		secciones.put("Inicio", true);
        secciones.put("NIngresar", false);
        secciones.put("NMostrar", false);
        secciones.put("NModificar", false);
        secciones.put("NContrato", false);
        secciones.put("NAsignacion", false);
        secciones.put("AIngresar", false);
        secciones.put("AMostrar", false);
        secciones.put("AModificar", false);
        secciones.put("AHistorial", false);
        secciones.put("PIngresar", false);
        secciones.put("PMostrar", false);
        secciones.put("PModificar", false);
        secciones.put("IIngresar", false);
        secciones.put("IRetirar", false);
        secciones.put("IMostrar", false);
        secciones.put("Perfil", false);
	}
	
	@GetMapping("/admin")
	public String principal(Model modelo) {
		if(secciones.get("NMostrar")) {
			empleados = empService.buscarTodos();
		}
		if(secciones.get("AMostrar")) {
			animales = aniService.reporteAnimales();
		}
		if(secciones.get("NIngresar")) {
			emp=new Empleado();
		}
		if(secciones.get("AIngresar")) {
			ani=new Animal();
		}
		modelo.addAttribute("empleado",emp);
		modelo.addAttribute("empleados",empleados);
		modelo.addAttribute("animal",ani);
		modelo.addAttribute("animales", animales);
		modelo.addAttribute(prov);
		modelo.addAttribute("contrato",contE);
		modelo.addAttribute("historial", histo);
		modelo.addAttribute("asignacion", asig);
		modelo.addAttribute("secciones", secciones);
		return "vistaAdmin";
	}
	
	@GetMapping("/mostrar-seccion/{seccion}")
	public String mostrarSeccion(@PathVariable String seccion) {
		
		actualizaS(seccion);
		return "redirect:/servicio/admin";
	}
	
	@PostMapping("/empleado/insertar")
	public String ingresarE(Empleado emp) {		
		emp.setContrasenia("12345");
		empService.registrar(emp);
		emp.setId(empService.seleccinarCedula(emp.getCedula()).getId());
		this.emp=emp;
		actualizaS("NContrato");
		
		return "redirect:/servicio/admin";
	}
	
	@PostMapping("/empleado/contrato")
	public String ingresaContrato(ContratoEmpleados contrato) {
		contrato.setEmpleado(emp);
		contEService.actualizar(emp.getCedula(), contrato);
		actualizaS("Inicio");
		this.emp=new Empleado();
		return "redirect:/servicio/admin";
	}
	
	@GetMapping("/empleado/buscarId/{id}")
	public String buscarEId(@PathVariable("id") Integer id) {
		Empleado temp = this.empService.buscar(id);
		this.emp=temp;
		actualizaS("NModificar");
		return "redirect:/servicio/admin";
	}
	
	@GetMapping("/contrato/buscarId/{id}")
	public String buscarCId(@PathVariable("id") Integer id) {
		Empleado temp = this.empService.buscar(id);
		this.emp=temp;
		actualizaS("NContrato");
		return "redirect:/servicio/admin";
	}
	
	@GetMapping("/asignacion/buscarId/{id}")
	public String buscarAsId(@PathVariable("id") Integer id) {
		Empleado temp = this.empService.buscar(id);
		this.emp=temp;
		actualizaS("NAsignacion");
		return "redirect:/servicio/admin";
	}
	
	@PutMapping("/empleado/modificar/{id}")
	public String actualizarE(@PathVariable("id")Integer id, Empleado emp) {	
		emp.setId(id);
		if(emp.getFechaNacimiento()==null) {
			emp.setFechaNacimiento(this.empService.buscar(id).getFechaNacimiento());
		}
		empService.actualizar(emp);
		actualizaS("NMostrar");
		return "redirect:/servicio/admin";
	}
	
	@PostMapping("/empleado/asignacion")
	public String ingresaAsignacion(Asignacion asig) {
		emp.getAsignaciones().add(asig);
		empService.actualizar(emp);
		asig.setEmpleado(emp);
		asigService.guardar(asig);
		actualizaS("Inicio");
		this.emp=new Empleado();
		return "redirect:/servicio/admin";
	}
	
	
	private void actualizaS(String seccion) {
		for(String secc:secciones.keySet()) {
			if(secc.equals(seccion)) {
				secciones.put(seccion, true);
			}else {
				secciones.put(secc, false);
			}
		}
	}
	
	
	
	////Animales
	
	@PostMapping("/animal/insertar")
	public String ingresarA(Animal ani) {
		aniService.guadar(ani);
		actualizaS("Inicio");		
		return "redirect:/servicio/admin";
	}
	
	@GetMapping("/animal/buscarId/{id}")
	public String buscarAnId(@PathVariable("id") Integer id) {
		Animal temp = this.aniService.buscarId(id);
		this.ani=temp;
		actualizaS("AModificar");
		return "redirect:/servicio/admin";
	}
	
	@GetMapping("/historial/buscarId/{id}")
	public String buscarHId(@PathVariable("id") Integer id) {
		Animal temp = this.aniService.buscarId(id);
		this.ani=temp;
		actualizaS("AHistorial");
		return "redirect:/servicio/admin";
	}
	
	@PutMapping("/animal/modificar/{id}")
	public String actualizarA(@PathVariable("id")Integer id, Animal ani) {	
		ani.setId(id);
		aniService.actualizar(ani);
		actualizaS("AMostrar");
		return "redirect:/servicio/admin";
	}
	
	@PostMapping("/animal/historial")
	public String ingresaAsignacion(HistorialMedico	histo) {
		ani.getHistorialMedico().add(histo);
		aniService.actualizar(ani);
		histo.setAnimal(ani);
		histoService.guardar(histo);
		actualizaS("Inicio");
		this.ani=new Animal();
		return "redirect:/servicio/admin";
	}
	
}
