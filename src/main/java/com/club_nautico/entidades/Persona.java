package com.club_nautico.entidades;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Persona", uniqueConstraints = {@UniqueConstraint(columnNames = {"dni"})})
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DNI", nullable = false)
	private String dni;
	
	@Column(name = "NOMBRES", nullable = false)
	private String nombre;
	
	@Column(name = "APELLIDOS", nullable = false)
	private String apellidos;
	
	@Column(name = "TELEFONOS", nullable = false)
	private String telefono;
	
	@Column(name = "Socio", nullable = false)
	private Boolean esSocio;
	
	@Column(name = "Patron", nullable = false)
	private Boolean esPatron;
	
	@JsonBackReference(value = "persona-barcos")
	@OneToMany(mappedBy = "persona", cascade  = CascadeType.ALL, orphanRemoval = true)
	private Set<Barco> barcos = new HashSet<>();

	/*
	@JsonBackReference(value = "persona-salidas")
	@OneToMany(mappedBy = "patron", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<SalidasBarco> salidasBarco = new HashSet<>();
	*/
	
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

	
	public Set<Barco> getBarcos() {
		return barcos;
	}

	public void setBarcos(Set<Barco> barcos) {
		this.barcos = barcos;
	}

	public Persona() {
		super();
	}

	public Persona(Long id, String dni, String nombre, String apellidos, String telefono, Boolean esSocio,
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
