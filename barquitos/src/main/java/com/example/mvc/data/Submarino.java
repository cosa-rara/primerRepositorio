package com.example.mvc.data;

public class Submarino extends Barco {
	
	private Casilla[] posicion;
	private String marcador;
	private String nombre;
	private Integer longitud;
	
	public Submarino() {
		this.posicion = new Casilla[4];
		this.marcador="S";
		this.nombre="submarino";
		this.longitud=4;
	}
	
	public String getMarcador() {
		return marcador;
	}

	public void setMarcador(String marcador) {
		this.marcador = marcador;
	}

	public String toString() {
		
		String posiciones="";
		
		for (Casilla casilla:posicion) {posiciones = posiciones +casilla.getLetra() +casilla.getNumero();}
		
		return " submarino (4 casillas) "
				+ posiciones;
	}

	public Casilla[] getPosicion() {
		return posicion;
	}

	public void setPosicion(Casilla[] posicion) {
		this.posicion = posicion;
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
