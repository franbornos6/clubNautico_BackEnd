package com.club_nautico.servicio;

import java.util.List;

import com.club_nautico.dto.PersonaDTO;

public interface PersonaServicio {

	public PersonaDTO crearPersona (PersonaDTO personaDto);
	
	public List<PersonaDTO> getAllPersonas();
	
	public PersonaDTO getPersonaById(Long id);
	
	public PersonaDTO actualizarPersona(PersonaDTO personaDTO, long id);
	
	public void eliminarPersona(long id);
	
}
