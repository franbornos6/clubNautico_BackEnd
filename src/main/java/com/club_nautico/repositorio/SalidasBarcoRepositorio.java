package com.club_nautico.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.club_nautico.entidades.SalidasBarco;

public interface SalidasBarcoRepositorio extends JpaRepository<SalidasBarco, Long>{
	
	public List<SalidasBarco> findByBarcoId(long barcoId);
	
	public List<SalidasBarco> findByPatronId(long patronId);

}
