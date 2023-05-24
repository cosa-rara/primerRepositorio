package com.example.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mvc.servicio.ComparadorPuntuacion;
import com.example.mvc.servicio.ServicioUsuario;
import com.example.mvc.userData.Usuario;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	Logger log = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	ServicioUsuario servicio;
	
	@GetMapping
	public String paginaMenu() {
		return "menu";
	}
	
	@GetMapping("/ranking")
	public String paginaRanking(Model model) {
		log.info("[paginaRanking]");
		
		List<Usuario> listaUsuarios = servicio.listar();
		
		
		hacerRanking(listaUsuarios);
		
		model.addAttribute("listaUsuarios", listaUsuarios);
			
		return "ranking";
	}
	
	public void hacerRanking(List<Usuario> listaUsuarios) {
		
	listaUsuarios.sort(new ComparadorPuntuacion());

	
	}
	
}
