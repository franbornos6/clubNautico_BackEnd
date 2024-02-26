package com.club_nautico.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.club_nautico.dto.AuthResponseDTO;
import com.club_nautico.dto.LoginRequestDTO;
import com.club_nautico.dto.RegisterRequestDTO;
import com.club_nautico.entidades.Rol;
import com.club_nautico.entidades.Usuario;
import com.club_nautico.repositorio.UsuarioRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

	private final UsuarioRepositorio usuarioRepositorio;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	
	@Override
	public AuthResponseDTO login(LoginRequestDTO request) {
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		UserDetails usuario = usuarioRepositorio.findByUsername(request.getUsername()).orElseThrow();
		String token = jwtService.getToken(usuario);
		return AuthResponseDTO.builder()
				.token(token)
				.build();
		
	}

	
	@Override
	public AuthResponseDTO register(RegisterRequestDTO request) {
		Usuario usuario = Usuario.builder()
							.username(request.getUsername())
							.password(passwordEncoder.encode(request.getPassword()))
							.nombre(request.getNombre())
							.apellidos(request.getApellidos())
							.email(request.getEmail())
							.rol(Rol.USER)
							.build();
		
		usuarioRepositorio.save(usuario);
		
		return AuthResponseDTO.builder()
				.token(jwtService.getToken(usuario))
				.build();
	}

}
