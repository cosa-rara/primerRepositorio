package com.example.mvc.data;

import java.util.ArrayList;
import java.util.List;

import com.example.mvc.common.ListaLetras;

import jakarta.persistence.Entity;


public class TableroDisparos {
	
	private Casilla[][] tableroDisparos;
	
	public TableroDisparos() {
		this.tableroDisparos = new Casilla[10][10];
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
				fila=fila+tableroDisparos[i][j];							
			}
			matriz = matriz +"\n\n" +fila;
		}
		String tablero = letras  +matriz;
		return tablero;
	}
	
	public Casilla[][] getTableroDisparos() {
		return tableroDisparos;
	}

	public void setTableroDisparos(Casilla[][] tableroDisparos) {
		this.tableroDisparos = tableroDisparos;
	}

	public  Casilla[] getPrimeraColumna() {
		Casilla[] primeraColumna = new Casilla[tableroDisparos[0].length];
		for(int i=0; i<10; i++) {			
				primeraColumna[i]= this.tableroDisparos[i][0];
				
		}
		return primeraColumna;
	}
	
	public Casilla[] getPrimeraFila() {
		
		Casilla[] primeraFila = new Casilla[tableroDisparos[0].length];
	
		for(int i=0; i<10; i++) {
			primeraFila[i] = this.tableroDisparos[0][i];
		}
		return primeraFila;
	}
	
	public List<Casilla[]> getListaFilas(){
		List<Casilla[]> listaFilas=new ArrayList<Casilla[]>();
		Casilla[] aux = new Casilla[10];
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				aux[j]=tableroDisparos[i][j];
			}
			listaFilas.add(aux);		
		}
		return listaFilas;
	}
	
	public void rellenarTablero() {
		Casilla aux;
		String letra;
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				letra = ListaLetras.letras.substring(j,j+1);
				aux = new Casilla(letra,i+1);   //i+1 para que las coordenadas empiecen en 1 , no 0
				this.tableroDisparos[i][j]=aux;
				
			}
		}
		
	}

	public void introducirBarcos(ListaBarcos listaBarcos) {
		
		String coordenadas;
		rellenarTablero();
		
		for (String cadena:listaBarcos.todasLasPosiciones()) {
			for (Casilla[] fila:this.tableroDisparos) {
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
}
