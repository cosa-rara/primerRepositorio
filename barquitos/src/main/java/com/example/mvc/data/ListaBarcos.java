package com.example.mvc.data;

import java.util.ArrayList;
import java.util.List;

public class ListaBarcos {
	
	List<Barco> lista;
	
	public ListaBarcos() {
		lista = new ArrayList<Barco>();
		crearBarcos();
	}
		
	public void crearBarcos() {
		
		lista.add(new Acorazado());
		lista.add(new Submarino());
		lista.add(new Submarino());
		lista.add(new Destructor());
		lista.add(new Fragata());
		lista.add(new Fragata());

		
	}

	public List<Barco> getLista() {
		return lista;
	}

	public void setLista(List<Barco> lista) {
		this.lista = lista;
	}
	
	
	public List<String> todasLasPosiciones() {
		
		List<String> posiciones = new ArrayList<String>();
		
		for (Barco barco:this.lista) {
			for(Casilla casilla:barco.getPosicion())
				posiciones.add(casilla.getLetra() + casilla.getNumero());
		}
		return  posiciones;
	}
	
	
}
