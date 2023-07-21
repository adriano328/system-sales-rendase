package com.rendase.rendase.services;

import com.rendase.rendase.controller.dto.ProdutoDTO;
import com.rendase.rendase.domain.Produto;
import com.rendase.rendase.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void save(Produto produto) {
         produtoRepository.save(produto);
    }

}
