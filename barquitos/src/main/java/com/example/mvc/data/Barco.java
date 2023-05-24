package com.example.mvc.data;

public abstract class Barco  {
	
	private Casilla[] posicion;
	private String marcador;
	private Integer longitud;
	private String nombre;

	public Integer getLongitud() {
		return longitud;
	}

	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}

	public Casilla[] getPosicion() {
		return posicion;
	}

	public void setPosicion(Casilla[] posicion) {
		this.posicion = posicion;
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
	
	//--------------------para desarrollo -----------------------------
	
	public String toString() {
		
		
		
		return this.nombre;
	}
	
	

}
