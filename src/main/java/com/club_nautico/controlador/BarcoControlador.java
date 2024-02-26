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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.club_nautico.dto.BarcoDTO;
import com.club_nautico.entidades.Barco;
import com.club_nautico.servicio.BarcoServicio;

import jakarta.validation.Valid;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/barcos")
public class BarcoControlador {
	
	@Autowired
	private BarcoServicio barcoServicio;
	
	@PostMapping
	public ResponseEntity<BarcoDTO> createBarco(@Valid @RequestBody BarcoDTO barcoDTO){
		return new ResponseEntity<>(barcoServicio.createBarco(barcoDTO), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<BarcoDTO>> getAllBarcos(){
		return ResponseEntity.ok(barcoServicio.getAllBarcos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BarcoDTO> getBarcoById(@PathVariable(name = "id") long id){
		BarcoDTO barcoDTO = barcoServicio.getBarcoById(id);
		return new ResponseEntity<>(barcoDTO, HttpStatus.OK);
	}
	
	@GetMapping("/persona/{personaId}")
	public ResponseEntity<List<BarcoDTO>> getBarcoByPersonaId(@PathVariable(name = "personaId") long personaId){
		return ResponseEntity.ok(barcoServicio.getBarcosByPersonaId(personaId));
	}
	
	
	@PutMapping("/{barcoId}")
	public ResponseEntity<BarcoDTO> updateBarco(@PathVariable(name = "barcoId") long barcoId, @Valid @RequestBody BarcoDTO barcoDTO){
		BarcoDTO barcoActualizado = barcoServicio.updateBarco(barcoId, barcoDTO);
		return new ResponseEntity<>(barcoActualizado,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBarcoById(@PathVariable(name = "id") long barcoId){
		barcoServicio.deleteBarco(barcoId);
		
		return new ResponseEntity<>("Barco eliminado con exito", HttpStatus.OK);
	}
	/*
	 
	 
	 
	@GetMapping("/personas/{personaId}/barcos")
	public List<BarcoDTO> listarBarcosPorPersonaId(@PathVariable(value = "personaId") Long personaId){
		return barcoServicio.obtenerBarcosPorPersonaId(personaId);
	}
	
	@GetMapping("/personas/{personaId}/barcos/{id}")
	public ResponseEntity<BarcoDTO> obtenerBarcoPorId(@PathVariable(value = "personaId") Long personaId, @PathVariable(value = "id") Long barcoId){
		BarcoDTO barcoDTO = barcoServicio.obtenerBarcoPorId(personaId, barcoId);
		return new ResponseEntity<>(barcoDTO,HttpStatus.OK);
		
	}
	
	@PostMapping("/personas/{personaId}/barcos")
	public ResponseEntity<BarcoDTO> guardarBarco(@PathVariable(value = "personaId") long personaId, @RequestBody BarcoDTO barcoDTO){
		return new ResponseEntity<>(barcoServicio.crearBarco(personaId, barcoDTO), HttpStatus.CREATED);
	}
	
	@PutMapping("/personas/{personaId}/barcos/{id}")
	public ResponseEntity<BarcoDTO> actualizarBarco(@PathVariable(value = "personaId") Long personaId, @PathVariable(value = "id") Long barcoId,@RequestBody BarcoDTO barcoDTO){
		BarcoDTO barcoActualizado = barcoServicio.actulizarBarco(personaId, barcoId, barcoDTO);
		return new ResponseEntity<>(barcoActualizado,HttpStatus.OK);
	}
	
	@DeleteMapping("/personas/{personaId}/barcos/{id}")
	public ResponseEntity<String> eliminarBarco(@PathVariable(value = "personaId") Long personaId, @PathVariable(value = "id") Long barcoId){
		barcoServicio.eliminarBarco(personaId, barcoId);
		
		return new ResponseEntity<>("Barco eliminado con exito", HttpStatus.OK);
		
	}
	
	*/

}
