package com.example.mvc.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.servicio.ServicioUsuario;
import com.example.mvc.userData.Usuario;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/inicio")
public class InicioController {
	Logger log = LoggerFactory.getLogger(InicioController.class);
	
	@Autowired
	ServicioUsuario servicio;
	
	
	@GetMapping
	public String paginaInicio() {
		log.info("[paginaInicio]");
		return "inicio";
	}
	
	@GetMapping("/login")
	public String paginaLogin() {
		log.info("[paginaLogin]");
		
		return "login";
	}
	
	@GetMapping("/registro")
	public String paginaRegistro() {
		log.info("[paginaRegistro]");
		return "registro";
	}
	
	@PostMapping("/login")
	public String formularioLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
		log.info("[formularioLogin]");
		
		List<Usuario> listaUsuarios = servicio.listar();
		String direccion="login";
		
		for(Usuario usuario:listaUsuarios) {
			if(usuario.getUserName().equals(username)) {
				if(usuario.getPassword().equals(password)) {
					
					session.setAttribute("usuario", usuario);
					log.debug("Introducimos en session 'usuario':"+usuario);
					direccion = "redirect:/menu";
				}
			}
		}
		return direccion;
		
	}
	
	@PostMapping("/registro")
	public String formularioRegistro(@ModelAttribute Usuario usuario,Model model) {
		log.info("[formularioRegistro]");
		
		usuario=servicio.grabar(usuario);
		
		model.addAttribute("usuario",usuario);
		return "redirect:/inicio";
		
	}
	

}
