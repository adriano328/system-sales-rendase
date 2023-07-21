package com.rendase.rendase.repositories;

import com.rendase.rendase.controller.dto.GetAllWithName;
import com.rendase.rendase.controller.dto.GetAllWithProduto;
import com.rendase.rendase.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    @Query("select new com.rendase.rendase.controller.dto.GetAllWithProduto("
            + "p.descricao, p.categoria, p.cor, p.preco, p.tamanho, p.sexo) from Produto p "
            + "where (:descricao IS null OR p.descricao LIKE %:descricao%) "
            + "AND (:categoria is null OR p.categoria LIKE %:categoria%) "
            + "AND (:cor is null OR p.cor LIKE %:cor%) "
            + "AND (:tamanho is null OR p.tamanho LIKE %:tamanho%) "
            + "AND (:sexo is null OR p.sexo LIKE %:sexo%)")
    Page<GetAllWithProduto> getAllWithProduto(String descricao, String categoria,
                                              String cor, String tamanho,
                                              String sexo, Pageable pageable);

}
