package com.example.mvc.data;


import java.util.List;

import com.example.mvc.common.ListaLetras;
import com.example.mvc.controllers.FaseColocacionController;

public class TableroBarcos extends Tablero {
	
	List Barcos;
	Casilla[][] tableroBarcos;
	
	public TableroBarcos() {
		this.tableroBarcos=new Casilla[10][10];
		rellenarTablero();
	}
	
	public String toString() {
		String fila="";
		int numeroFila;
		String matriz="";
		String letras="   .a. .b. .c. .d. .e. .f. .g. .h. .i. .j.";
		
		for(int i=0; i<10; i++) {
			numeroFila = i+1;
			if (numeroFila!=10) {fila=numeroFila +" ";}
			else {fila=numeroFila+"";}
			
			for(int j=0; j<10; j++) {
				fila=fila+tableroBarcos[i][j];							
			}
			matriz = matriz +"\n\n" +fila;
		}
		String tablero = letras  +matriz;
		return tablero;
	}
	
	// cambiar el atributo "ocupado" de las casillas que coincidan con posiciones de barcos
	public void introducirBarcos(ListaBarcos listaBarcos) {
		
		String coordenadas;
		
		for (String cadena:listaBarcos.todasLasPosiciones()) {
			for (Casilla[] fila:tableroBarcos) {
				for(Casilla casilla:fila) {
					
					coordenadas=casilla.getLetra()+casilla.getNumero();
					if(cadena.equals(coordenadas)) {
						
						System.out.print(coordenadas);
						
						casilla.setOcupacion(true);
					}
					
				}
				
			}
			
		}
		
	}
	
	
	//llena el tablero con 100 casillas
	public void rellenarTablero() {
		Casilla aux;
		String letra;
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				letra = ListaLetras.letras.substring(j,j+1);
				aux = new Casilla(letra,i);
				this.tableroBarcos[i][j]=aux;
				
			}
		}
		
	}
	
	
	public List getBarcos() {
		return Barcos;
	}

	public void setBarcos(List barcos) {
		Barcos = barcos;
	}

	public Casilla[][] getTableroBarcos() {
		return tableroBarcos;
	}

	public void setTableroBarcos(Casilla[][] tableroBarcos) {
		this.tableroBarcos = tableroBarcos;
	}
	
	public  Casilla[] getPrimeraColumna() {
		Casilla[] primeraColumna = new Casilla[tableroBarcos[0].length];
		for(int i=0; i<10; i++) {			
				primeraColumna[i]= this.tableroBarcos[i][0];
				
		}
		return primeraColumna;
	}
	
	public Casilla[] getPrimeraFila() {
		
		Casilla[] primeraFila = new Casilla[tableroBarcos[0].length];
	
		for(int i=0; i<10; i++) {
			primeraFila[i] = this.tableroBarcos[0][i];
		}
		return primeraFila;
	
	}
		
}
