package com.club_nautico.servicio;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {
	
	public UserDetailsService userDetailsService();

}
