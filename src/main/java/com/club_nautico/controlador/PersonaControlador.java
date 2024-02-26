package com.club_nautico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.club_nautico.dto.PersonaDTO;
import com.club_nautico.servicio.PersonaServicio;

import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/personas")
@PermitAll
public class PersonaControlador {

	@Autowired
	private PersonaServicio personaServicio;
	
	@PostMapping
	@PermitAll
	public ResponseEntity<PersonaDTO> crearPersona(@Valid @RequestBody PersonaDTO personaDTO){
		return new ResponseEntity<>(personaServicio.crearPersona(personaDTO), HttpStatus.CREATED);
		
	}
	
	@GetMapping
	@PermitAll
	public List<PersonaDTO> listarPersonas(){
		return personaServicio.getAllPersonas();
	}
	
	@GetMapping("/{id}")
	@PermitAll
	public ResponseEntity<PersonaDTO> obtenerPersonaPorId(@PathVariable(name = "id") long id){
		return ResponseEntity.ok(personaServicio.getPersonaById(id));
	}
	
	@PutMapping("/{id}")
	@PermitAll
	public ResponseEntity<PersonaDTO> actualizarPersona(@Valid @RequestBody PersonaDTO personaDTO, @PathVariable(name = "id") long id){
		PersonaDTO personaRespuesta = personaServicio.actualizarPersona(personaDTO, id);
		return new ResponseEntity<>(personaRespuesta,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	@PermitAll
	public ResponseEntity<String> eliminarPersonas(@PathVariable(name = "id") long id){
		personaServicio.eliminarPersona(id);
		return new ResponseEntity<>(HttpStatus.OK);
		//return new ResponseEntity<>("Persona eliminada con exito", HttpStatus.OK);
		
	}
	
	
}
