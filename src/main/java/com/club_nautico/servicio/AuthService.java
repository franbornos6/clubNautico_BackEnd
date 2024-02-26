package com.club_nautico.servicio;

import com.club_nautico.dto.AuthResponseDTO;
import com.club_nautico.dto.LoginRequestDTO;
import com.club_nautico.dto.RegisterRequestDTO;

public interface AuthService {
	
	public AuthResponseDTO login(LoginRequestDTO request);
	
	public AuthResponseDTO register(RegisterRequestDTO request);

}
