package org.iesalixar.grados.controller;

import java.util.List;

import org.iesalixar.grados.dto.GradoDTO;
import org.iesalixar.grados.model.Grado;
import org.iesalixar.grados.services.GradoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradoController {
	
	@Autowired
	GradoServiceImpl gradoService;
	
	@GetMapping("/grados") 
	public String grados(Model model) {
		
		List<Grado> grados = gradoService.getAllGrados();
	
		model.addAttribute("grados",grados);
		
		return "grados";
	}

	@GetMapping("/grados/addGrado")
	public String addGradoGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="grado") String nombre,
			Model model) {
		
		GradoDTO grado = new GradoDTO();
		
		model.addAttribute("grado", grado);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		return "addGrado";
	}
	
	@PostMapping("/grados/addGrado")
	public String addGradoPost(@ModelAttribute GradoDTO grado, Model model) {
		Grado gradoDB = new Grado();
		
		gradoDB.setNombre(grado.getNombre());
		
		if (gradoService.insertarGrado(gradoDB)==null) {
			return "redirect:/grados/addGrado?error=Existe&grado="+grado.getNombre();
		}
		
		return "redirect:/grados";
	}
}
