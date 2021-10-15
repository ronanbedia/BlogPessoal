package com.generation.blogPessoal.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.generation.blogPessoal.models.UsuarioModel;
import com.generation.blogPessoal.repositories.UsuarioRepository;

public class UserDetailsServiceImplements implements UserDetailsService {

	
	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UsuarioModel> user = userRepository.findByEmail(email);
		user.orElseThrow(() -> new UsernameNotFoundException(email + " not found."));

		return user.map(UserDetailsImplement::new).get();
	}

}