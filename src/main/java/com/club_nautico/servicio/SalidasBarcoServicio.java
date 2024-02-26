package com.club_nautico.servicio;

import java.util.List;

import com.club_nautico.dto.SalidasBarcoDTO;

public interface SalidasBarcoServicio {
	
	public SalidasBarcoDTO createSalida(SalidasBarcoDTO salidasBarcoDTO);
	
	public List<SalidasBarcoDTO> getAllSalidas();
	
	public SalidasBarcoDTO getSalidaById(long salidaId);
	
	public List<SalidasBarcoDTO> getSalidasByBarcoId(long barcoId);
	
	public List<SalidasBarcoDTO> getSalidasByPatronId(long patronId);
	
	public SalidasBarcoDTO updateSalida(long salidaId, SalidasBarcoDTO salidaBarcoDTO);
	
	public void deleteSalida(long salidaId);

}
