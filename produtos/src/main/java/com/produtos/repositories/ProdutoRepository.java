package com.produtos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
}
