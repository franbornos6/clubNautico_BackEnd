package com.club_nautico.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SalidasBarcoDTO {

	private long id;
	
	@NotEmpty
	@Size(max = 25, message = "El destino no puede tener mas de 25 caracteres.")
	private String destino;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate fecha;
	
	@NotNull
	@JsonFormat(pattern = "HH:mm")
	private LocalTime hora_salida;
	
	@NotNull
	private long barcoId;
	
	@NotNull
	private long patronId;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(LocalTime hora_salida) {
		this.hora_salida = hora_salida;
	}

	public long getBarcoId() {
		return barcoId;
	}

	public void setBarcoId(long barcoId) {
		this.barcoId = barcoId;
	}

	public long getPatronId() {
		return patronId;
	}

	public void setPatronId(long patronId) {
		this.patronId = patronId;
	}
	

	public SalidasBarcoDTO() {
		super();
	}

	public SalidasBarcoDTO(long id, String destino, LocalDate fecha, LocalTime hora_salida) {
		super();
		this.id = id;
		this.destino = destino;
		this.fecha = fecha;
		this.hora_salida = hora_salida;
	}
	
	//LocalTime hora_salida

	public SalidasBarcoDTO(long id, String destino, LocalDate fecha, LocalTime hora_salida, long barcoId,
			long patronId) {
		super();
		this.id = id;
		this.destino = destino;
		this.fecha = fecha;
		this.hora_salida = hora_salida;
		this.barcoId = barcoId;
		this.patronId = patronId;
	}

	
}
