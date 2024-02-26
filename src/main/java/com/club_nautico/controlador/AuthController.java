package com.club_nautico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.club_nautico.dto.AuthResponseDTO;
import com.club_nautico.dto.LoginRequestDTO;
import com.club_nautico.dto.RegisterRequestDTO;
import com.club_nautico.servicio.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO request) {
		
		return ResponseEntity.ok(authService.login(request)); 
	}
	
	@PostMapping("/register")
	public ResponseEntity<AuthResponseDTO> register(@RequestBody RegisterRequestDTO request) {
		
		return ResponseEntity.ok(authService.register(request)); 
	}

}
