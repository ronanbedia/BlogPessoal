package com.generation.blogPessoal.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogPessoal.models.UserLogin;
import com.generation.blogPessoal.models.UsuarioModel;
import com.generation.blogPessoal.repositories.UsuarioRepository;
import com.generation.blogPessoal.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repositorio;

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/logar")
	public ResponseEntity<UserLogin> Authentication(@RequestBody Optional<UserLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	/*
	 * @PostMapping("/cadastrar") public ResponseEntity<Usuario> Post(@RequestBody
	 * Usuario usuario) { return ResponseEntity.status(HttpStatus.CREATED)
	 * .body(usuarioService.CadastrarUsuario(usuario)); }
	 */

	@GetMapping("/todos")
	public ResponseEntity<List<UsuarioModel>> getAll() {
		if (repositorio.findAll().isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(repositorio.findAll());
		}
	}

	/*@PostMapping("/cadastro")
	public ResponseEntity<Object> cadastrar(@Valid @RequestBody UsuarioModel novoUsuario) {
		return suarioService.CadastrarUsuario(novoUsuario).map(resp -> ResponseEntity.status(201).body(resp))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Email existente, cadastre outro email!.");
				});*/

	@PostMapping("/cadastrar")
    public ResponseEntity<UsuarioModel> Post(@RequestBody UsuarioModel usuario) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.CadastrarUsuario(usuario));
    }

}