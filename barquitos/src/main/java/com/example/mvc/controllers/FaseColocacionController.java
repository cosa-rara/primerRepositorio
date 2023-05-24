package com.example.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mvc.common.ClaseMapeo;
import com.example.mvc.common.ClaseMapeoLista;
import com.example.mvc.data.Barco;
import com.example.mvc.data.Casilla;
import com.example.mvc.data.ListaBarcos;
import com.example.mvc.data.TableroBarcos;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/faseColocacion")
public class FaseColocacionController {
	
	private static ListaBarcos listaBarcos;
	static TableroBarcos tableroBarcos;
	
	
	@GetMapping
	public String mostrarFaseColocacion(Model model, HttpSession session) {
		
		if(session.getAttribute("usuario")== null)
			return "login";
		this.tableroBarcos = new TableroBarcos();
		listaBarcos = new ListaBarcos();
				
		model.addAttribute("tableroBarcos", tableroBarcos);
		model.addAttribute("listaBarcos", listaBarcos);
		
		return "faseColocacion";
	}
	
	@PostMapping
	public String grabarPosiciones(@ModelAttribute ClaseMapeo mapeo, Model model) {
		
		
		this.tableroBarcos = new TableroBarcos();
		
		listaBarcos = mapeoPosicionesBarcos(listaBarcos, mapeo);
		
		this.tableroBarcos.introducirBarcos(listaBarcos);
		
		//para comprobar
		System.out.println(tableroBarcos.toString());
		for(Barco barco:listaBarcos.getLista()) {System.out.println(barco);}
		
		return "redirect:/faseDisparos";
	}
	
	
	public ListaBarcos mapeoPosicionesBarcos(ListaBarcos listaBarcos, ClaseMapeo mapeo) {
		//mapea los arrays de posiciones que llegan de la faseColocacion
		// a la lista de barcos.
		
		
		ClaseMapeoLista cml = new ClaseMapeoLista();
		
		cml.getListaArraysPosiciones().add(mapeo.getAcorazadoPosiciones());
		cml.getListaArraysPosiciones().add( mapeo.getSubmarino1Posiciones());
		cml.getListaArraysPosiciones().add( mapeo.getSubmarino2Posiciones());
		cml.getListaArraysPosiciones().add( mapeo.getDestructorPosiciones());
		cml.getListaArraysPosiciones().add( mapeo.getFragata1Posiciones());
		cml.getListaArraysPosiciones().add( mapeo.getFragata2Posiciones());
		
		// haciendo esto hay que asegurarse de que esten en el mismo orden en la lista de barcos
	
		for (String[] arrayPosiciones:cml.getListaArraysPosiciones()) {
			
			int indice = cml.getListaArraysPosiciones().indexOf(arrayPosiciones);		
			Casilla[] arrayAux = new Casilla[arrayPosiciones.length];
			Casilla casillaAux;
			
			
			for (int i=0; i<arrayPosiciones.length; i++) {
				casillaAux = new Casilla(arrayPosiciones[i]);
				arrayAux[i]=casillaAux;
			}
			
			listaBarcos.getLista().get(indice).setPosicion(arrayAux);			
		}
		
		return listaBarcos;
		
	}

	public static ListaBarcos getListaBarcos() {
		return listaBarcos;
	}

	public static void setListaBarcos(ListaBarcos listaBarcos) {
		FaseColocacionController.listaBarcos = listaBarcos;
	}

	public static TableroBarcos getTableroBarcos() {
		return tableroBarcos;
	}

	public static void setTableroBarcos(TableroBarcos tableroBarcos) {
		FaseColocacionController.tableroBarcos = tableroBarcos;
	}
	
	
}
