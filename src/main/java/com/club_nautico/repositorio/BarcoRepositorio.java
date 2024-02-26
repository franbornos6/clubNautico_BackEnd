package com.club_nautico.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.club_nautico.entidades.Barco;

public interface BarcoRepositorio extends JpaRepository<Barco, Long>{

	public List<Barco> findByPersonaId(long personaId);
}
