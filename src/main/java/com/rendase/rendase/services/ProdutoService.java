package com.rendase.rendase.services;

import com.rendase.rendase.controller.dto.ClienteDTO;
import com.rendase.rendase.controller.dto.GetAllWithName;
import com.rendase.rendase.controller.dto.GetAllWithProduto;
import com.rendase.rendase.controller.dto.ProdutoDTO;
import com.rendase.rendase.domain.Cliente;
import com.rendase.rendase.domain.Produto;
import com.rendase.rendase.exception.NotFoundException;
import com.rendase.rendase.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.util.Objects.isNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void save(Produto produto) {
         produtoRepository.save(produto);
        log.info("Cadastrando Produto");
    }

    public Produto getById(Long id) {
        log.info("Buscando Produto");
        return produtoRepository.findById(id).orElseThrow(() -> new NotFoundException("Produto não localizado!"));
    }

    @Transactional
    public void delete(Long id) {
        Produto ProdutoToDelete = getById(id);
        produtoRepository.delete(ProdutoToDelete);
        log.info("Deletando Produto");
    }

    @Transactional
    public void alterar(final Produto produto) {
        produtoRepository.save(produto);
        log.info("Alterando cadastro de Produto");
    }

    public Page<GetAllWithProduto> getAllWithName(String descricao, String categoria,
                                                  String tamanho, String cor,
                                                  String sexo, Pageable pageable) {
        log.info("Buscando todos os produtos");
        return produtoRepository.getAllWithProduto(descricao, categoria, cor, tamanho, sexo, pageable);
    }

}
