package com.club_nautico.servicio;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {

	public String getToken(UserDetails usuario);

	public String getUsernameFromToken(String token);

	public boolean isTokenValid(String token, UserDetails userDetails);
	
}
