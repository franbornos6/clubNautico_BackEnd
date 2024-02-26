package com.club_nautico.dto;

import java.util.Set;

import com.club_nautico.entidades.Barco;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PersonaDTO {

	private Long id;
	
	@NotEmpty
	@Pattern(regexp = "^[0-9]{8}[A-Z]{1}", message = "El DNI debe tener el formato: 12345678A")
	private String dni;
	
	@NotEmpty
	@Size(max = 20, message = "El nombre no puede tener mas de 20 caracteres.")
	private String nombre;
	
	@NotEmpty
	@Size(max = 30, message = "El nombre no puede tener mas de 30 caracteres.")
	private String apellidos;
	
	@NotEmpty
	@Pattern(regexp = "(6)([0-9]){8}", message = "El numero de telefono debe tener el formato: 6XXXXXXXX")
	private String telefono;
	
	@NotNull
	private Boolean esSocio;
	
	@NotNull
	private Boolean esPatron;
	
	//private Set<Barco> barcos;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Boolean getEsSocio() {
		return esSocio;
	}

	public void setEsSocio(Boolean esSocio) {
		this.esSocio = esSocio;
	}

	public Boolean getEsPatron() {
		return esPatron;
	}

	public void setEsPatron(Boolean esPatron) {
		this.esPatron = esPatron;
	}
/*
	public Set<Barco> getBarcos() {
		return barcos;
	}

	public void setBarcos(Set<Barco> barcos) {
		this.barcos = barcos;
	}
	*/
	public PersonaDTO() {
		super();
	}

	public PersonaDTO(Long id, String dni, String nombre, String apellidos, String telefono, Boolean esSocio,
			Boolean esPatron) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.esSocio = esSocio;
		this.esPatron = esPatron;
	}
	
}
