package com.generation.blogPessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogPessoal.models.PostagemModel;
import com.generation.blogPessoal.repositories.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;
	

	@GetMapping
	public ResponseEntity<List<PostagemModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostagemModel> GetById(@PathVariable long id) {
		return repository.findById(id).stream().map(resp -> ResponseEntity.ok(resp)).findAny()
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<PostagemModel>> GetByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<PostagemModel> Post(@RequestBody PostagemModel novaPostagem) {
		return ResponseEntity.status(201).body(repository.save(novaPostagem));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<PostagemModel> Put(@RequestBody PostagemModel atualizarPostagem) {
		return ResponseEntity.status(200).body(repository.save(atualizarPostagem));
	}

	@DeleteMapping("/deletar/{id}")
	public void DeleteById(@PathVariable long id) {
		repository.deleteById(id);
	}

}