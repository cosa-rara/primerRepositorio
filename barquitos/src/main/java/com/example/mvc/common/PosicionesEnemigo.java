package com.example.mvc.common;

import com.example.mvc.data.Barco;
import com.example.mvc.data.Casilla;
import com.example.mvc.data.ListaBarcos;

public class PosicionesEnemigo {
	
	private Casilla[][] matrizPosiciones;
	
	private ListaBarcos listaBarcosEnemigos;
	
	public PosicionesEnemigo() {
		this.listaBarcosEnemigos = new ListaBarcos();
		introducirPosiciones();
		crearLista();
		
		
		
	}
	
	public void crearLista(){
		int i = 0;
		for (Barco barco:listaBarcosEnemigos.getLista()) {
			barco.setPosicion(matrizPosiciones[i]);
			i++;
		}
		i=0;
		
	}
	
	public void introducirPosiciones() {
		this.matrizPosiciones= new Casilla[][] 
				{{new Casilla("a1"), new Casilla("a2"), new Casilla("a3"), new Casilla("a4"), new Casilla("a5")},
				{new Casilla("b1"), new Casilla("b2"), new Casilla("b3"), new Casilla("b4")},
				{new Casilla("c1"), new Casilla("c2"), new Casilla("c3"), new Casilla("c4")},
				{new Casilla("d1"), new Casilla("d2"), new Casilla("d3")},
				{new Casilla("e1"), new Casilla("e2"), new Casilla("e3")},
				{new Casilla("f1"), new Casilla("f2"), new Casilla("f3")}};
	}
//	public void nose() {
//		
//		for(Barco barco:listaBarcosEnemigos.getLista()) {
//			
//		}
//		
//	
//	}
	
	public void mostrarPosiciones() {
		for (Casilla[] fila:matrizPosiciones) {
			for(Casilla casilla:fila) {
				System.out.print(casilla.getLetra() +casilla.getNumero());
			}
			System.out.println("");
		}
		
	}

	public Casilla[][] getMatrizPosiciones() {
		return matrizPosiciones;
	}

	public void setMatrizPosiciones(Casilla[][] matrizPosiciones) {
		this.matrizPosiciones = matrizPosiciones;
	}

	public ListaBarcos getListaBarcosEnemigos() {
		return listaBarcosEnemigos;
	}

	public void setListaBarcosEnemigos(ListaBarcos listaBarcosEnemigos) {
		this.listaBarcosEnemigos = listaBarcosEnemigos;
	}

}
