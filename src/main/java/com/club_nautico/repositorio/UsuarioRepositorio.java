package com.club_nautico.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.club_nautico.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	
	Optional<Usuario> findByUsername(String username);

}
