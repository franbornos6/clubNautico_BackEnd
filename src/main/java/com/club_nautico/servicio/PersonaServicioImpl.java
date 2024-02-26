package com.club_nautico.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club_nautico.dto.PersonaDTO;
import com.club_nautico.entidades.Persona;
import com.club_nautico.excepciones.ResourceNotFoundException;
import com.club_nautico.repositorio.PersonaRepositorio;

@Service
public class PersonaServicioImpl implements PersonaServicio{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PersonaRepositorio personaRepositorio;
	
	@Override
	public PersonaDTO crearPersona(PersonaDTO personaDTO) {

		Persona persona = mapearEntidad(personaDTO);
		
		Persona nuevaPersona = personaRepositorio.save(persona);
		
		PersonaDTO personaRespuesta = mapearDTO(nuevaPersona);
		
		return personaRespuesta;
	}

	@Override
	public List<PersonaDTO> getAllPersonas() {
		
		List<Persona> personas = personaRepositorio.findAll();
		
		return personas.stream().map(persona -> mapearDTO(persona)).collect(Collectors.toList());
	}
	

	@Override
	public PersonaDTO getPersonaById(Long id) {
		Persona persona = personaRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Persona", "id", id));
		return mapearDTO(persona);
	}

	@Override
	public PersonaDTO actualizarPersona(PersonaDTO personaDTO, long id) {
		Persona persona = personaRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Persona", "id", id));
		
		persona.setDni(personaDTO.getDni());
		persona.setNombre(personaDTO.getNombre());
		persona.setApellidos(personaDTO.getApellidos());
		persona.setTelefono(personaDTO.getTelefono());
		persona.setEsSocio(personaDTO.getEsSocio());
		persona.setEsPatron(personaDTO.getEsPatron());
		
		Persona personaActualizada = personaRepositorio.save(persona);
		
		return mapearDTO(personaActualizada);
		
	}

	@Override
	public void eliminarPersona(long id) {
		Persona persona = personaRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Persona", "id", id));
		
		personaRepositorio.delete(persona);
		
	}

	
	//CONVIERTE ENTIDAD A DTO
	
		private PersonaDTO mapearDTO(Persona persona) {
			PersonaDTO personaDTO = modelMapper.map(persona, PersonaDTO.class);
			
			/*
			 * SIN USAR modelMapper
			 * 
			PersonaDTO personaDTO = new PersonaDTO();
			
			
			personaDTO.setId(persona.getId());
			personaDTO.setDni(persona.getDni());
			personaDTO.setNombre(persona.getNombre());
			personaDTO.setApellidos(persona.getApellidos());
			personaDTO.setTelefono(persona.getTelefono());
			personaDTO.setEsSocio(persona.getEsSocio());
			personaDTO.setEsPatron(persona.getEsPatron());
			*/
			return personaDTO;
		}
		
		
		// CONVIERTE DE DTO A ENTIDAD
		
		private Persona mapearEntidad(PersonaDTO personaDTO) {
			Persona persona = modelMapper.map(personaDTO, Persona.class);
			
			/*
			Persona persona = new Persona();
			
			persona.setId(personaDTO.getId());
			persona.setDni(personaDTO.getDni());
			persona.setNombre(personaDTO.getNombre());
			persona.setApellidos(personaDTO.getApellidos());
			persona.setTelefono(personaDTO.getTelefono());
			persona.setEsSocio(personaDTO.getEsSocio());
			persona.setEsPatron(personaDTO.getEsPatron());
			*/
			return persona;
		}
		
		/*
		//Convertimos de DTO a Entidad para guardar en BBDD
		
		Persona persona = new Persona();
		persona.setDni(personaDTO.getDni());
		persona.setNombre(personaDTO.getNombre());
		persona.setApellidos(personaDTO.getApellidos());
		persona.setTelefono(personaDTO.getTelefono());
		
		Persona nuevaPersona = personaRepositorio.save(persona);
		
		
		//Convertimos de Entidad a DTO
		
		PersonaDTO personaRespuesta = new PersonaDTO();
		personaRespuesta.setDni(nuevaPersona.getDni());
		personaRespuesta.setNombre(nuevaPersona.getNombre());
		personaRespuesta.setApellidos(nuevaPersona.getApellidos());
		personaRespuesta.setTelefono(nuevaPersona.getTelefono());
		
		return personaRespuesta;
		*/

}
