package com.example.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.common.PosicionesEnemigo;
import com.example.mvc.data.ListaBarcos;
import com.example.mvc.data.TableroBarcos;
import com.example.mvc.data.TableroDisparos;
import com.example.mvc.servicio.ServicioUsuario;
import com.example.mvc.userData.Usuario;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/faseDisparos")
public class FaseDisparosController {
	
	TableroDisparos tableroDisparos;
	
	@Autowired
	ServicioUsuario servicio;
	
	
	@GetMapping
	public String mostrarTablero(Model model) {
		
		
		TableroBarcos tableroBarcos = FaseColocacionController.tableroBarcos;
		this.tableroDisparos = new TableroDisparos();
		
		
		PosicionesEnemigo posicionesEnemigo = new PosicionesEnemigo();
		ListaBarcos listaBarcosEnemigos = posicionesEnemigo.getListaBarcosEnemigos();
		tableroDisparos.introducirBarcos(listaBarcosEnemigos);
	
		model.addAttribute("tableroDisparos", tableroDisparos);
		model.addAttribute("tableroBarcos", tableroBarcos);
				
		return "faseDisparos";
	}
	
	@PostMapping
	public String mostrarTablero(@RequestParam String resultado, Model model, HttpSession session) {
		
		Usuario usuario = (Usuario)(session.getAttribute("usuario"));
	
		if (resultado.equals("victoria")) {
			usuario.setVictorias(usuario.getVictorias()+1);
			servicio.grabar(usuario);
		}
		if (resultado.equals("derrota")) {
			usuario.setDerrotas(usuario.getDerrotas()+1);
		}
		
		
		return "redirect:/menu";
	}
	
//	public void prepararTableroDisparos(TableroDisparos tableroDisparos) {
//		PosicionesEnemigo posicionesEnemigo = new PosicionesEnemigo();
//		ListaBarcos listaBarcosEnemigos = posicionesEnemigo.getListaBarcosEnemigos();
//		tableroDisparos.introducirBarcos(listaBarcosEnemigos);
//	}

}
