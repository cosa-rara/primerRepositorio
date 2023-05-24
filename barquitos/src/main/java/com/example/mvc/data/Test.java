package com.example.mvc.data;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		ListaBarcos listaBarcos = new ListaBarcos();
		
		System.out.println("funciona");
		
		for(Barco barco:listaBarcos.getLista()) {
			System.out.println("barco");
		}
//		
//		lista.add(new Acorazado());
		
		
		
	}

}
