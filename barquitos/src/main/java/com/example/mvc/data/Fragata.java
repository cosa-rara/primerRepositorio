package com.example.mvc.data;

public class Fragata extends Barco {
	
	private Casilla[] posicion;
	private String nombre;
	private Integer longitud;
	
	public Fragata() {
		this.posicion = new Casilla[5];
		this.nombre="fragata";
		this.longitud=2;
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
