package com.generation.blogPessoal.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.blogPessoal.models.UsuarioModel;
import com.generation.blogPessoal.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UsuarioModel> objetoOptional = userRepository.findByEmail(username);

        if (objetoOptional.isPresent()) {
            return new UserDetailsImplement(objetoOptional.get());
        } else {
            throw new UsernameNotFoundException(username + " Não existe!");
        }

    }
}