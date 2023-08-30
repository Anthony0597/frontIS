package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.modelo.Animal;
import com.example.demo.repository.modelo.Asignacion;
import com.example.demo.repository.modelo.ContratoEmpleados;
import com.example.demo.repository.modelo.ContratoProveedores;
import com.example.demo.repository.modelo.Empleado;
import com.example.demo.repository.modelo.HistorialMedico;
import com.example.demo.repository.modelo.Producto;
import com.example.demo.repository.modelo.Proveedor;
import com.example.demo.service.AsignacionService;
import com.example.demo.service.EmpleadoService;
import com.example.demo.service.IAnimalService;
import com.example.demo.service.IContratoEService;
import com.example.demo.service.IContratoPService;
import com.example.demo.service.IHistorialMedicoService;
import com.example.demo.service.IProductoService;
import com.example.demo.service.IProveedorService;

@Controller
@RequestMapping("/servis")
public class EmpleadoController {
	
	private static Empleado user;
	@Autowired
	private EmpleadoService empService;
	@Autowired
	private IContratoEService contEService;
	@Autowired
	private AsignacionService asigService;
	@Autowired
	private IAnimalService aniService;
	@Autowired
	private IHistorialMedicoService histoService;
	@Autowired
	private IProveedorService provService;
	@Autowired
	private IContratoPService contPService;
	@Autowired
	private IProductoService prodService;
	
	private static Map<String, Boolean> secciones = new HashMap<>();
	private  Empleado emp = new Empleado();
	private  Animal ani = new Animal();
	private  Proveedor prov = new Proveedor();
	private  Producto prod = new Producto();
	private Asignacion asig = new Asignacion();
	private ContratoEmpleados contE = new ContratoEmpleados();
	private ContratoProveedores contP = new ContratoProveedores(); 
	private HistorialMedico histo = new HistorialMedico();
	private List<Empleado> empleados ;
	private List<Animal> animales ;
	private List<Proveedor> proveedores;
	private List<Producto> productos;
	
	public EmpleadoController() {
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
        secciones.put("PContrato", false);
        secciones.put("IIngresar", false);
        secciones.put("IMostrar", false);
        secciones.put("IModificar", false);
        secciones.put("IStock", false);
        secciones.put("IError", false);
	}
	
	@GetMapping("/admin")
	public String principal(Model modelo) {
		user=empService.buscarCorreo(emp.getCorreo());
		if(secciones.get("NMostrar")) {
			empleados = empService.buscarTodos();
		}
		if(secciones.get("AMostrar")) {
			animales = aniService.reporteAnimales();
		}
		if(secciones.get("PMostrar")) {
			proveedores = provService.reporteProveedor();
		}
		if(secciones.get("IMostrar")) {
			productos = prodService.buscar();
		}
		if(secciones.get("NIngresar")) {
			emp=new Empleado();
		}
		if(secciones.get("AIngresar")) {
			ani=new Animal();
		}
		if(secciones.get("PIngresar")) {
			prov=new Proveedor();
		}
		if(secciones.get("IIngresar")) {
			prod=new Producto();
		}
		if(secciones.get("IError")) {
			prod=new Producto();
		}
		if(secciones.get("IIngresar")) {
			proveedores = provService.reporteProveedor();
		}
		if(secciones.get("Inicio")) {
			proveedores = new ArrayList<>();
		}
		modelo.addAttribute("usuario", user);
		modelo.addAttribute("empleado",emp);
		modelo.addAttribute("empleados",empleados);
		modelo.addAttribute("animal",ani);
		modelo.addAttribute("animales", animales);
		modelo.addAttribute("proveedor",prov);
		modelo.addAttribute("proveedores",proveedores);
		modelo.addAttribute("producto",prod);
		modelo.addAttribute("productos",productos);
		modelo.addAttribute("contrato",contE);
		modelo.addAttribute("contratop",contP);
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

	//////Empleado
	
	
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
	
	/////Proveedor
	
	@PostMapping("/proveedor/insertar")
	public String ingresarA(Proveedor prov) {
		provService.agregar(prov);
		prov.setId(provService.buscarNombre(prov.getNombreEmpresa()).getId());
		this.prov=prov;
		actualizaS("PContrato");	
		return "redirect:/servicio/admin";
	}
	
	@PostMapping("/proveedor/contrato")
	public String ingresaContratoP(ContratoProveedores contratoP) {
		contratoP.setProveedor(prov);
		provService.buscarId(prov.getId()).setContrato_proveedores(contratoP);
		provService.actualizar(prov);
		if(contPService.buscarContratoId(contratoP.getId())==null) {
			contPService.agregarContrato(contratoP);
		}else {
			contPService.actualizar(contratoP);
		}		
		actualizaS("Inicio");
		this.prov=new Proveedor();
		return "redirect:/servicio/admin";
	}
	
	@GetMapping("/proveedor/buscarId/{id}")
	public String buscarPId(@PathVariable("id") Integer id) {
		Proveedor temp = this.provService.buscarId(id);
		this.prov=temp;
		actualizaS("PModificar");
		return "redirect:/servicio/admin";
	}
	
	@GetMapping("/contratoP/buscarId/{id}")
	public String buscarCPId(@PathVariable("id") Integer id) {
		Proveedor temp = this.provService.buscarId(id);
		this.prov=temp;
		actualizaS("PContrato");
		return "redirect:/servicio/admin";
	}
	
	@PutMapping("/proveedor/modificar/{id}")
	public String actualizarP(@PathVariable("id")Integer id, Proveedor prov) {	
		prov.setId(id);
		empService.actualizar(emp);
		actualizaS("NMostrar");
		return "redirect:/servicio/admin";
	}
	
	/////Producto
	
	@PostMapping("/producto/insertar")
	public String ingresarProd(Producto prod, @RequestParam("proveedorId") Integer proveedorId) {		
		Proveedor tmp = provService.buscarId(proveedorId);
		prod.setProveedor(tmp);
		prodService.agregar(prod);
		tmp.getListaProductos().add(prod);
		provService.actualizar(tmp);
		actualizaS("Inicio");
		
		return "redirect:/servicio/admin";
	}
	
	@GetMapping("/producto/buscarId/{id}")
	public String buscarProdId(@PathVariable("id") String id) {
		Producto temp = this.prodService.buscarId(id);
		this.prod=temp;
		actualizaS("IModificar");
		return "redirect:/servicio/admin";
	}
	
	@GetMapping("/stock/buscarId/{id}")
	public String buscarsId(@PathVariable("id") String id) {
		Producto temp = this.prodService.buscarId(id);
		this.prod=temp;
		actualizaS("IStock");
		return "redirect:/servicio/admin";
	}
	
	@PutMapping("/producto/modificar/{id}")
	public String actualizarProd(@PathVariable("id")String id, Producto prod) {	
		prodService.actualizar(prod);
		actualizaS("IMostrar");
		return "redirect:/servicio/admin";
	}
	
	@PutMapping("/stock/modificar/{id}")
	public String actualizarStock(@PathVariable("id")String id, Producto prod, @RequestParam("nuevoStock") Integer nuevoS) {	
		Producto tmp=prodService.buscarId(id);
		if(tmp.getStock()+nuevoS<0) {
			actualizaS("IError");
		}else {
			tmp.setStock(tmp.getStock()+nuevoS);
			prodService.actualizar(tmp);
			actualizaS("IMostrar");
		}
		
		return "redirect:/servicio/admin";
	}
}
