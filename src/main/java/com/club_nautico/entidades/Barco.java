package com.club_nautico.entidades;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Barco", uniqueConstraints = {@UniqueConstraint(columnNames = {"matricula", "n_amarre"})})
public class Barco {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "matricula", nullable = false)
	private String matricula;
	
	@Column(name = "n_amarre", nullable = false)
	private Integer n_amarre;
	
	@Column(name = "cuota", nullable = false)
	private Integer cuota;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id", nullable = false)
	private Persona persona;
	
	
	@JsonBackReference(value = "barco-salida")
	@OneToMany(mappedBy = "barco", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<SalidasBarco> salidasBarco = new HashSet<>();

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Integer getN_amarre() {
		return n_amarre;
	}

	public void setN_amarre(Integer n_amarre) {
		this.n_amarre = n_amarre;
	}

	public Integer getCuota() {
		return cuota;
	}

	public void setCuota(Integer cuota) {
		this.cuota = cuota;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Set<SalidasBarco> getSalidasBarco() {
		return salidasBarco;
	}

	public void setSalidasBarco(Set<SalidasBarco> salidasBarco) {
		this.salidasBarco = salidasBarco;
	}

	public Barco() {
		super();
	}

	public Barco(long id, String matricula, Integer n_amarre, Integer cuota, Persona persona) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.n_amarre = n_amarre;
		this.cuota = cuota;
		this.persona = persona;
	}
	
	
	
	
}
