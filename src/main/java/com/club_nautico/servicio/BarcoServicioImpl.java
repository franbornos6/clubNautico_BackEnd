package com.club_nautico.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.club_nautico.dto.BarcoDTO;
import com.club_nautico.dto.SalidasBarcoDTO;
//import com.club_nautico.dto.SalidasBarcoDTO;
import com.club_nautico.entidades.Barco;
import com.club_nautico.entidades.Persona;
import com.club_nautico.entidades.SalidasBarco;
//import com.club_nautico.entidades.SalidasBarco;
import com.club_nautico.excepciones.ClubNauticoAppException;
import com.club_nautico.excepciones.ResourceNotFoundException;
import com.club_nautico.excepciones.ResourceNotPatronException;
import com.club_nautico.repositorio.BarcoRepositorio;
import com.club_nautico.repositorio.PersonaRepositorio;

@Service
public class BarcoServicioImpl implements BarcoServicio {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private BarcoRepositorio barcoRepositorio;
	
	@Autowired
	private PersonaRepositorio personaRepositorio;

	
	public BarcoDTO createBarco(BarcoDTO barcoDTO) {
		/*
		Barco barco = mapearEntidad(barcoDTO);
		Persona persona = personaRepositorio.findById(barcoDTO.getPersonaId()).orElseThrow(() -> new ResourceNotFoundException("Persona", "id", barcoDTO.getPersonaId()));
		
		//Barco barco = modelMapper.map(barcoDTO, Barco.class);
		
		barco.setPersona(persona);
		
		Barco barcoNuevo = barcoRepositorio.save(barco);
		return mapearDTO(barcoNuevo);
		*/
		
		Persona persona = personaRepositorio.findById(barcoDTO.getPersonaId()).orElseThrow(() -> new ResourceNotFoundException("Persona", "id", barcoDTO.getPersonaId()));
		Barco barco = modelMapper.map(barcoDTO, Barco.class);
		
		barco.setPersona(persona);
		
		Barco barcoNuevo = barcoRepositorio.save(barco);
		return mapearDTO(barcoNuevo);
	}

	/*
	@Override
	public BarcoDTO crearBarco(long personaId, BarcoDTO barcoDTO) {
		Barco barco = mapearEntidad(barcoDTO);
		Persona persona = personaRepositorio.findById(personaId).orElseThrow(() -> new ResourceNotFoundException("Persona", "id", personaId));
		
		barco.setPersona(persona);
		Barco nuevoBarco = barcoRepositorio.save(barco);
		
		return mapearDTO(nuevoBarco);
	}
	*/
	
	public List<BarcoDTO> getAllBarcos(){
		List<Barco> barcos = barcoRepositorio.findAll();
		return barcos.stream().map(barco -> mapearDTO(barco)).collect(Collectors.toList());
	}

	
	public BarcoDTO getBarcoById(long barcoId) {
		Barco barco = barcoRepositorio.findById(barcoId).orElseThrow(() -> new ResourceNotFoundException("Barco", "id", barcoId));
		return mapearDTO(barco);
	}
	
	
	public List<BarcoDTO> getBarcosByPersonaId(long personaId){
		
		List<Barco> barcos = barcoRepositorio.findByPersonaId(personaId);
		return barcos.stream().map(barco -> mapearDTO(barco)).collect(Collectors.toList());
	}
	
	
	public BarcoDTO updateBarco(Long barcoId, BarcoDTO nuevoBarco){
		Barco barco = barcoRepositorio.findById(barcoId).orElseThrow(() -> new ResourceNotFoundException("Barco", "id", barcoId));
		Persona persona = personaRepositorio.findById(nuevoBarco.getPersonaId()).orElseThrow(() -> new ResourceNotFoundException("Persona", "id", nuevoBarco.getPersonaId()));
		
		barco.setMatricula(nuevoBarco.getMatricula());
		barco.setN_amarre(nuevoBarco.getN_amarre());
		barco.setCuota(nuevoBarco.getCuota());
		barco.setPersona(persona);
			
		Barco barcoActualizado = barcoRepositorio.save(barco);
		
		return mapearDTO(barcoActualizado);
	}
	
	public void deleteBarco(Long barcoId) {
		Barco barco = barcoRepositorio.findById(barcoId).orElseThrow(() -> new ResourceNotFoundException("Barco", "id", barcoId));
		
		barcoRepositorio.delete(barco);
	}	
	
	/*

	@Override
	public BarcoDTO actulizarBarco(Long personaId, Long barcoId, BarcoDTO solicitudDeBarco) {
		Persona persona = personaRepositorio.findById(personaId).orElseThrow(() -> new ResourceNotFoundException("Persona", "id", personaId));
		
		Barco barco = barcoRepositorio.findById(barcoId).orElseThrow(() -> new ResourceNotFoundException("Barco", "id", barcoId));
		
		if(!barco.getPersona().getId().equals(persona.getId())) {
			throw new ClubNauticoAppException(HttpStatus.BAD_REQUEST, "El barco no pertenece a la persona");
		}
		
		barco.setMatricula(solicitudDeBarco.getMatricula());
		barco.setN_amarre(solicitudDeBarco.getN_amarre());
		barco.setCuota(solicitudDeBarco.getCuota());
		
		Barco barcoActualizado = barcoRepositorio.save(barco);
		
		return mapearDTO(barcoActualizado);
	}	
	
	*/
	private BarcoDTO mapearDTO(Barco barco){
		BarcoDTO barcoDTO = modelMapper.map(barco, BarcoDTO.class);
		
		/*
		BarcoDTO barcoDTO = new BarcoDTO();
		barcoDTO.setId(barco.getId());
		barcoDTO.setMatricula(barco.getMatricula());
		barcoDTO.setN_amarre(barco.getN_amarre());
		barcoDTO.setCuota(barco.getCuota());
		*/
		return barcoDTO;
	}
	
	private Barco mapearEntidad(BarcoDTO barcoDTO) {
		Barco barco = modelMapper.map(barcoDTO, Barco.class);
		
		/*
		Barco barco = new Barco();
		barco.setId(barcoDTO.getId());
		barco.setMatricula(barcoDTO.getMatricula());
		barco.setN_amarre(barcoDTO.getN_amarre());
		barco.setCuota(barcoDTO.getCuota());
		*/
		return barco;
	}

}
