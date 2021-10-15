package com.generation.blogPessoal.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "tb_postagem")
public class PostagemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String titulo;

    @NotNull
    private String texto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new java.sql.Date(System.currentTimeMillis());

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnoreProperties("postagem")
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "id_tema")
    @JsonIgnoreProperties("postagem")
    private TemaModel tema;

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public TemaModel getTema() {
        return tema;
    }

    public void setTema(TemaModel tema) {
        this.tema = tema;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}