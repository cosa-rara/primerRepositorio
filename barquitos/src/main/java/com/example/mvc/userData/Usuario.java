package com.example.mvc.userData;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIOS")
public class Usuario {
	
	@Id
	@Column(name="USUARIO_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="VICTORIAS")
	private Integer victorias;
	
	@Column(name="DERROTAS")
	private Integer derrotas;
	
	
	public Usuario() {
		
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getVictorias() {
		return victorias;
	}


	public void setVictorias(Integer victorias) {
		this.victorias = victorias;
	}


	public Integer getDerrotas() {
		return derrotas;
	}


	public void setDerrotas(Integer derrotas) {
		this.derrotas = derrotas;
	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return userName +id;
	}
	
	

}
