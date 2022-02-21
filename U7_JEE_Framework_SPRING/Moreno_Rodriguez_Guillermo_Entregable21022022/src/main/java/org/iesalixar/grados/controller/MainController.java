package org.iesalixar.grados.controller;

import org.iesalixar.grados.dto.UsuarioDTO;
import org.iesalixar.grados.model.Usuario;
import org.iesalixar.grados.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	
	
	@Autowired
	UsuarioServiceImpl usuarioService;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("contenido","INICIO");
		return "index";
	}
	
	
	@GetMapping("/register")
	public String registerGet(Model model) {
		
		UsuarioDTO userDTO = new UsuarioDTO();		
		model.addAttribute("usuario", userDTO);		
		return "register";
	}
	
	@PostMapping("/register")
	public String registerPost(@ModelAttribute UsuarioDTO usuario) {
		
		Usuario userBD = new Usuario();
		userBD.setActivo(true);
		userBD.setNombre(usuario.getNombre());
		userBD.setApellidos(usuario.getApellidos());
		userBD.setUserName(usuario.getUsuario());
		userBD.setRole("ROLE_USER");
		userBD.setEmail(usuario.getEmail());		
		userBD.setPassword(new BCryptPasswordEncoder(15).encode(usuario.getPassword()));
		
		userBD = usuarioService.insertUsuario(userBD);
		
		if (userBD==null) {
			return "redirect:/register";
		}
		
		return "redirect:/";
		
	}	
	

}
