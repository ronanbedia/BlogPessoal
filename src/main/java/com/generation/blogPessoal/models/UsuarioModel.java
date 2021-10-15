package com.generation.blogPessoal.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 2, max = 100)
	private String nome;

	@NotBlank
	@Size(min = 5, max = 100)
	private String usuario;

	@Email(message = "O atributo Usuário deve ser um email válido!")
	@Size(min = 5, max = 100)
	private String email;

	@NotBlank
	@Size(min = 5, max = 100)
	private String senha;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tema")
	private List<PostagemModel> postagem = new ArrayList<>();

	public UsuarioModel(Long id, String nome, String usuario, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
    }

	public UsuarioModel(String nome, String usuario, String email, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
    }

	public UsuarioModel () {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<PostagemModel> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<PostagemModel> postagem) {
        this.postagem = postagem;
    }
}