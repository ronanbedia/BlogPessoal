package com.generation.blogPessoal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.blogPessoal.models.PostagemModel;

public interface PostagemRepository  extends JpaRepository<PostagemModel, Long> {

    /**
     * Metodo utilizado para realizar pesquisa pela coluna titulo da tabela postagem
     */
    public List<PostagemModel> findAllByTituloContainingIgnoreCase(String titulo);

    public List<PostagemModel> findById(long id);

}