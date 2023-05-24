package com.example.mvc.servicio;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.repositories.UserRepository;
import com.example.mvc.userData.Usuario;

@Service
public class ServicioUsuario implements Servicio <Usuario>{
	
	Logger log = LoggerFactory.getLogger(ServicioUsuario.class);
	
	@Autowired
	UserRepository repositorio;

	@Override
	public List<Usuario> listar() {
		log.info("[listUsuarios]");
		List<Usuario> listaUsuarios=repositorio.findAll();		
		return listaUsuarios;
	}

	@Override
	public Optional<Usuario> conseguirPorId(Integer id) {
		log.info("[conseguirUsuario]");
		log.debug("[idUsuario: "+id+"]");
		
		Optional<Usuario> usuario = repositorio.findById(id);
		return usuario;
	}

	@Override
	public Usuario grabar(Usuario registro) {
		log.info("[grabarUsuario]");
		
		Usuario usuario = repositorio.save(registro);
		return usuario;
	}

	@Override
	public void eliminarPorId(Integer id) {
		log.info("[eliminarUsuario]");
		log.debug("[idUsuario: "+id+"]");
		
		repositorio.deleteById(id);
		
	}

	

}
