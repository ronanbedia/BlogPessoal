package com.generation.blogPessoal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.blogPessoal.models.UsuarioModel;
import com.generation.blogPessoal.models.UsuarioModel.Usuario;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

	public Optional<Usuario> findByUsuario(String usuario);

	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

	public UsuarioModel findByNome(String nome);

	public UsuarioModel save(Usuario usuario);

}