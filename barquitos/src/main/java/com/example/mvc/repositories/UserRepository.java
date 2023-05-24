package com.example.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc.userData.Usuario;

public interface UserRepository extends JpaRepository<Usuario,Integer>{

}
