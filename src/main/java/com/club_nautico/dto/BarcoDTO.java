package com.club_nautico.dto;

import java.util.Set;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

//import com.club_nautico.entidades.SalidasBarco;

public class BarcoDTO {
	
	private long id;
	
	
	//@NotNull
	@NotEmpty
	@Pattern(regexp = "[0-9]{4}", message = "La matricula debe tener el formato: 1234")
	//@Digits(fraction=0, integer=4)
	private String matricula;
	
	@NotNull
	@Min(1)
	@Max(100)
	private Integer n_amarre;
	
	@NotNull
	@Min(0)
	@Max(1000)
	private Integer cuota;
	
	//private Set<SalidasBarco> salidas;
	
	private long personaId;

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

	/*
	public Set<SalidasBarco> getSalidas() {
		return salidas;
	}

	public void setSalidas(Set<SalidasBarco> salidas) {
		this.salidas = salidas;
	}
*/
	
	public long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(long personaId) {
		this.personaId = personaId;
	}

	public BarcoDTO() {
		super();
	}

	public BarcoDTO(long id, String matricula, Integer n_amarre, Integer cuota, long personaId) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.n_amarre = n_amarre;
		this.cuota = cuota;
		this.personaId = personaId;
	}
	
	

}
