package com.generation.blogPessoal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.blogPessoal.models.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {


	public List<UsuarioModel> findAllByNomeContainingIgnoreCase(String nome);

	public UsuarioModel findByNome(String nome);

	public Optional<UsuarioModel> findByEmail(String email);

	//public Optional<UsuarioModel> findByUsuario(String usuario);



}