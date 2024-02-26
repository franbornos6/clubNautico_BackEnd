package com.club_nautico.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club_nautico.dto.BarcoDTO;
import com.club_nautico.dto.SalidasBarcoDTO;
import com.club_nautico.entidades.Barco;
import com.club_nautico.entidades.Persona;
import com.club_nautico.entidades.SalidasBarco;
import com.club_nautico.excepciones.ResourceNotFoundException;
import com.club_nautico.excepciones.ResourceNotPatronException;
import com.club_nautico.repositorio.BarcoRepositorio;
import com.club_nautico.repositorio.PersonaRepositorio;
import com.club_nautico.repositorio.SalidasBarcoRepositorio;

@Service
public class SalidasBarcoServicioImpl implements SalidasBarcoServicio{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SalidasBarcoRepositorio salidasBarcoRepositorio;
	
	@Autowired
	private BarcoRepositorio barcoRepositorio;
	
	@Autowired
	private PersonaRepositorio personaRepositorio;
	
	// MAPEAR A DTO
	
	private SalidasBarcoDTO mapearADTO(SalidasBarco salidasBarco) {
		SalidasBarcoDTO salidasBarcoDTO = modelMapper.map(salidasBarco, SalidasBarcoDTO.class);
		return salidasBarcoDTO;
	}
	
	// MAPEAR A ENTIDAD
	
	private SalidasBarco mapearAEntidad(SalidasBarcoDTO salidasBarcoDTO) {
		SalidasBarco salidasBarco = modelMapper.map(salidasBarcoDTO, SalidasBarco.class);
		return salidasBarco;
	}

	@Override
	public SalidasBarcoDTO createSalida(SalidasBarcoDTO salidasBarcoDTO) {
		Persona persona = personaRepositorio.findById(salidasBarcoDTO.getPatronId()).orElseThrow(() -> new ResourceNotFoundException("Persona", "id", salidasBarcoDTO.getPatronId()));
		if(persona.getEsPatron() != true) {
			throw new ResourceNotPatronException("Persona", "id", salidasBarcoDTO.getPatronId());
		}
		
		Barco barco = barcoRepositorio.findById(salidasBarcoDTO.getBarcoId()).orElseThrow(() -> new ResourceNotFoundException("Barco", "id", salidasBarcoDTO.getBarcoId()));
		
		SalidasBarco salidasBarco = modelMapper.map(salidasBarcoDTO, SalidasBarco.class);
		
		salidasBarco.setBarco(barco);
		salidasBarco.setPatron(persona);
		
		SalidasBarco salidaNueva = salidasBarcoRepositorio.save(salidasBarco);
		
		return mapearADTO(salidaNueva);
	}

	@Override
	public List<SalidasBarcoDTO> getAllSalidas() {
		List<SalidasBarco> salidas = salidasBarcoRepositorio.findAll();
		return salidas.stream().map(salida -> mapearADTO(salida)).collect(Collectors.toList());
	}

	@Override
	public SalidasBarcoDTO getSalidaById(long salidaId) {
		SalidasBarco salidasBarco = salidasBarcoRepositorio.findById(salidaId).orElseThrow(() -> new ResourceNotFoundException("Salida", "id", salidaId));
		return mapearADTO(salidasBarco);
	}

	@Override
	public List<SalidasBarcoDTO> getSalidasByBarcoId(long barcoId) {
		List<SalidasBarco> salidas = salidasBarcoRepositorio.findByBarcoId(barcoId);
		return salidas.stream().map(salida -> mapearADTO(salida)).collect(Collectors.toList());
	}

	@Override
	public List<SalidasBarcoDTO> getSalidasByPatronId(long patronId) {
		List<SalidasBarco> salidas = salidasBarcoRepositorio.findByPatronId(patronId);
		return salidas.stream().map(salida -> mapearADTO(salida)).collect(Collectors.toList());
	}

	@Override
	public SalidasBarcoDTO updateSalida(long salidaId, SalidasBarcoDTO nuevaSalida) {
		Barco barco = barcoRepositorio.findById(nuevaSalida.getBarcoId()).orElseThrow(() -> new ResourceNotFoundException("Barco", "id", nuevaSalida.getBarcoId()));
		Persona persona = personaRepositorio.findById(nuevaSalida.getPatronId()).orElseThrow(() -> new ResourceNotFoundException("Persona", "id", nuevaSalida.getPatronId()));
		if(persona.getEsPatron() != true) {
			throw new ResourceNotPatronException("Persona", "id", nuevaSalida.getPatronId());
		}
		
		SalidasBarco salidaBarco = salidasBarcoRepositorio.findById(salidaId).orElseThrow(() -> new ResourceNotFoundException("Salida", "id", salidaId));
		
		salidaBarco.setDestino(nuevaSalida.getDestino());
		salidaBarco.setFecha(nuevaSalida.getFecha());
		salidaBarco.setBarco(barco);
		salidaBarco.setPatron(persona);
		
		SalidasBarco salidaActualizada = salidasBarcoRepositorio.save(salidaBarco);
		
		return mapearADTO(salidaActualizada);
		
	}

	@Override
	public void deleteSalida(long salidaId) {
		SalidasBarco salidasbarco = salidasBarcoRepositorio.findById(salidaId).orElseThrow(() -> new ResourceNotFoundException("Salida", "id", salidaId));
		salidasBarcoRepositorio.delete(salidasbarco);
	}
	
}
