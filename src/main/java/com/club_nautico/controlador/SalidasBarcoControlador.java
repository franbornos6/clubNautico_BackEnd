package com.club_nautico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.club_nautico.dto.BarcoDTO;
import com.club_nautico.dto.SalidasBarcoDTO;
import com.club_nautico.repositorio.BarcoRepositorio;
import com.club_nautico.repositorio.PersonaRepositorio;
import com.club_nautico.repositorio.SalidasBarcoRepositorio;
import com.club_nautico.servicio.SalidasBarcoServicio;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/salidas")
public class SalidasBarcoControlador {
	
	@Autowired
	private SalidasBarcoServicio salidasBarcoServicio;
	
	@Autowired
	private BarcoRepositorio barcoRepositorio;
	
	@Autowired
	private PersonaRepositorio personaRepositorio;
	
	@PostMapping
	public ResponseEntity<SalidasBarcoDTO> createSalidaBarco(@Valid @RequestBody SalidasBarcoDTO salidasBarcoDTO){
		return new ResponseEntity<>(salidasBarcoServicio.createSalida(salidasBarcoDTO),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<SalidasBarcoDTO>> getAllSalidas(){
		return ResponseEntity.ok(salidasBarcoServicio.getAllSalidas());
	}
	
	@GetMapping("/{salidaId}")
	public ResponseEntity<SalidasBarcoDTO> getSalidaById(@PathVariable(name = "salidaId") long salidaId){
		return ResponseEntity.ok(salidasBarcoServicio.getSalidaById(salidaId));
	}
	
	@GetMapping("/barcos/{barcoId}")
	public ResponseEntity<List<SalidasBarcoDTO>> getSalidasByBarcoId(@PathVariable(name = "barcoId") long barcoId){
		return ResponseEntity.ok(salidasBarcoServicio.getSalidasByBarcoId(barcoId));
	}
	
	@GetMapping("/personas/{patronId}")
	public ResponseEntity<List<SalidasBarcoDTO>> getSalidasByPatronId(@PathVariable(name = "patronId") long patronId){
		return ResponseEntity.ok(salidasBarcoServicio.getSalidasByPatronId(patronId));
	}
	
	@PutMapping("/{salidaId}")
	public ResponseEntity<SalidasBarcoDTO> updateSalida(@PathVariable(name = "salidaId") long salidaId, @Valid @RequestBody SalidasBarcoDTO salidaBarcoDTO){
		SalidasBarcoDTO salidaActualizada = salidasBarcoServicio.updateSalida(salidaId, salidaBarcoDTO);
		return new ResponseEntity<>(salidaActualizada,HttpStatus.OK);
	}
	
	@DeleteMapping("/{salidaId}")
	public ResponseEntity<String> deleteSalidaById(@PathVariable(name = "salidaId") long salidaId){
		salidasBarcoServicio.deleteSalida(salidaId);
		
		return new ResponseEntity<>("Salida eliminada con exito", HttpStatus.OK);
	}

}
