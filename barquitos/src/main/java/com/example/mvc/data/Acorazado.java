package com.example.mvc.data;

public class Acorazado extends Barco{
	
	private Casilla[] posicion;
	private String marcador;
	private String nombre;
	private Integer longitud;
	
	public Acorazado() {
		this.posicion = new Casilla[5];
		this.marcador="A";
		this.nombre="acorazado";
		this.longitud=5;
	}

	public Casilla[] getPosicion() {
		return posicion;
	}

	public void setPosicion(Casilla[] posicion) {
		this.posicion = posicion;
	}
	
	public String toString() {
		
		String posiciones="";
		
		for (Casilla casilla:posicion) {posiciones = posiciones +casilla.getLetra() +casilla.getNumero();}
		
		return " acorazado (5 casillas) "
				+ posiciones;
	}

	public String getMarcador() {
		return marcador;
	}

	public void setMarcador(String marcador) {
		this.marcador = marcador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getLongitud() {
		return longitud;
	}

	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}
	
	
}
