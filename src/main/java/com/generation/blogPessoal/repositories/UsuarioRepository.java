package com.generation.blogPessoal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.blogPessoal.models.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

	public Optional<UsuarioModel> findByUsuario(String usuario);

	public List<UsuarioModel> findAllByNomeContainingIgnoreCase(String nome);

	public UsuarioModel findByNome(String nome);

	@SuppressWarnings("unchecked")
	public UsuarioModel save(UsuarioModel usuario);

	public Optional<UsuarioModel> findByEmail(String email);

}