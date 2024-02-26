package com.club_nautico.servicio;

import java.util.List;

import com.club_nautico.dto.BarcoDTO;

public interface BarcoServicio {
	
	//public BarcoDTO crearBarco(long personaId, BarcoDTO barcoDTO);   FRAN
	public BarcoDTO createBarco(BarcoDTO barcoDTO);
	
	public List<BarcoDTO> getAllBarcos();
	
	public BarcoDTO getBarcoById(long barcoId);
	
	//NO FUNCIONA
	
	public List<BarcoDTO> getBarcosByPersonaId(long personaId);
	
	public BarcoDTO updateBarco(Long barcoId, BarcoDTO nuevoBarco);
	
	public void deleteBarco(Long barcoId);
	
	/*
	
	//public BarcoDTO obtenerBarcoPorId(long personaId, long barcoId);  FRAN
	
	
	
	
	
	
	
	
	*/
}
