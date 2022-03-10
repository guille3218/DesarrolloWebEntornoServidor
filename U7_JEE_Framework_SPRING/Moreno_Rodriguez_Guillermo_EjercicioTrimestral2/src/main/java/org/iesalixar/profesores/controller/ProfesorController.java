package org.iesalixar.profesores.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.profesores.dto.ProfesorDTO;
import org.iesalixar.profesores.model.Departamento;
import org.iesalixar.profesores.model.Profesor;
import org.iesalixar.profesores.services.DepartamentoServiceImpl;
import org.iesalixar.profesores.services.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfesorController {
	@Autowired
	ProfesorServiceImpl profService;
	
	@Autowired
	DepartamentoServiceImpl depaService;
	
	@GetMapping("/profesores") 
	public String profesores(Model model) {
		
		List<Profesor> profesores = profService.getAllProfesores();
		
		
		
		for (Profesor profesor : profesores) {
			Optional<Departamento> departamento = depaService.findDepartamentoById(profesor.getId_departamento());
			profesor.setDepartamento(departamento.get().getNombre());
		}

		model.addAttribute("profesores",profesores);
		
		return "profesores";
	}
	
	@GetMapping("/profesores/asignaturas") 
	public String profesoresAsignaturas(Model model, @RequestParam(required=false,name="profesor") String profesorId) {

		
		if(profesorId != null) {
			Long profesorIdL = Long.parseLong(profesorId);
			
			Optional<Profesor> profesor = profService.findProfesorById(profesorIdL);
			
			model.addAttribute("profesor",profesor.get().getNombre()+" "+profesor.get().getApellido1());
			model.addAttribute("asignaturas",profesor.get().getAsignaturas());
		}else {
			model.addAttribute("profesor",null);
		}
		
		
		
		return "asignaturas";
	}

	@GetMapping("/profesores/addProfesor")
	public String addProfesorGet( Model model) {
		
		return "addProfesor";
	}
	
	
	@PostMapping("/profesores/addProfesor")
	public String addProfesorPost(@ModelAttribute ProfesorDTO profesor, Model model) {
		Profesor profesorDB = new Profesor();
		
		profesorDB.setNombre(profesor.getNombre());
		
		if (profService.insertarProfesor(profesorDB)==null) {
			return "redirect:/profesores/addProfesor?error=Existe&profesor="+profesor.getNombre();
		}
		
		return "redirect:/profesores";
	}

}
