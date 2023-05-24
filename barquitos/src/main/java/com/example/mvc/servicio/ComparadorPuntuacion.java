package com.example.mvc.servicio;

import java.util.Comparator;

import com.example.mvc.userData.Usuario;

public class ComparadorPuntuacion implements Comparator<Usuario>{

	@Override
	public int compare(Usuario u1, Usuario u2) {
		
		Integer puntuacion1 =u1.getVictorias()-u1.getDerrotas();
		Integer puntuacion2 =u2.getVictorias()-u2.getDerrotas();
	
		return puntuacion2.compareTo(puntuacion1);
	}

}
