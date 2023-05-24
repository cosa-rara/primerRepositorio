package com.example.mvc.common;

import java.util.ArrayList;
import java.util.List;

public class ClaseMapeoLista {
	
	List<String[]> listaArraysPosiciones;
	
	public ClaseMapeoLista() {
		this.listaArraysPosiciones = new ArrayList<String[]>();
	}

	public List<String[]> getListaArraysPosiciones() {
		return listaArraysPosiciones;
	}

	public void setListaArraysPosiciones(List<String[]> listaArraysPosiciones) {
		this.listaArraysPosiciones = listaArraysPosiciones;
	}
	
	

}
