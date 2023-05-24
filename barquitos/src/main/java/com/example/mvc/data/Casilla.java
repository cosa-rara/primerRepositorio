package com.example.mvc.data;

public class Casilla {
	
	private String letra;
	private Integer numero;
	private int impacto;//0(nada), 1(impacto en agua), 2(impacto en barco)
	private String marcador;
	private Boolean ocupacion;
	
	
	public Casilla(String letra, int numero) {
		this.letra=letra;
		this.numero=numero;
		this.impacto=0;
		this.ocupacion=false;
	}
	public Casilla() {
		
		this.impacto=0;
		this.ocupacion=false;
	}
	
	public Casilla(String coordenadas) { // para construir con parametro tipo "c2" o "a7" etc...
		
		this.numero=Integer.parseInt(coordenadas.substring(1, 2));
		this.letra=coordenadas.substring(0,1);
		this.ocupacion=false;
		
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public int getImpacto() {
		return impacto;
	}

	public void setImpacto(int impacto) {
		this.impacto = impacto;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	
	
	public String getMarcador() {
		return marcador;
	}

	public void setMarcador(String marcador) {
		this.marcador = marcador;
	}

	public String toString() {
		
		String representacion=" |_|";
		
		if (this.impacto==0) {representacion = " |_|";}
		else if (this.impacto==1) {representacion = " |O|";}
		else if (this.impacto==2) {representacion = " |X|";}
		
		if(this.ocupacion==true) {representacion = " |B|";};
		
		if (marcador!=null) {representacion = " |" +marcador +"|";}
		
		return representacion;
		
	}
	public Boolean getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(Boolean ocupacion) {
		this.ocupacion = ocupacion;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
}
