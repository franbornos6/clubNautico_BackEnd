package com.club_nautico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.club_nautico.entidades.Persona;

public interface PersonaRepositorio extends JpaRepository<Persona, Long>{

}
