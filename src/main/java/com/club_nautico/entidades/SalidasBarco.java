package com.club_nautico.entidades;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "salidas")
public class SalidasBarco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "destino", nullable = false)
	private String destino;
	
	@Column(name = "fecha", nullable = false)
	private LocalDate fecha;
	
	@JsonFormat(pattern = "hh:mm")
	@Column(name = "hora_salida", nullable = true)
	private LocalTime hora_salida;
	
	@ManyToOne
	@JoinColumn(name = "barco_id", nullable = false)
	private Barco barco;
	
	@ManyToOne
	@JoinColumn(name = "patron_id", nullable = false)
	private Persona patron;

	
	
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

	public Barco getBarco() {
		return barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}

	public Persona getPatron() {
		return patron;
	}

	public void setPatron(Persona patron) {
		this.patron = patron;
	}

	public SalidasBarco() {
		super();
	}

	public SalidasBarco(long id, String destino, LocalDate fecha,LocalTime hora_salida, Barco barco, Persona patron) {
		super();
		this.id = id;
		this.destino = destino;
		this.fecha = fecha;
		this.hora_salida = hora_salida;
		this.barco = barco;
		this.patron = patron;
	}
	
	

}
