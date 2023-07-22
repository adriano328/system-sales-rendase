package com.rendase.rendase.services;


import com.rendase.rendase.controller.dto.GetAllWithProduto;
import com.rendase.rendase.domain.Categoria;
import com.rendase.rendase.domain.Produto;
import com.rendase.rendase.exception.NotFoundException;
import com.rendase.rendase.repositories.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository  categoriaRepository;

    @Transactional
    public void save(Categoria categoria) {
        categoriaRepository.save(categoria);
        log.info("Cadastrando Categoria");
    }

    public Categoria getById(Long id) {
        log.info("Buscando categoria");
        return categoriaRepository.findById(id).orElseThrow(() -> new NotFoundException("Categoria não localizada!"));
    }

    @Transactional
    public void delete(Long id) {
        Categoria categoriaToDelete = getById(id);
        categoriaRepository.delete(categoriaToDelete);
        log.info("Deletando Categoria");
    }

    @Transactional
    public void alterar(final Categoria categoria) {
        categoriaRepository.save(categoria);
        log.info("Alterando cadastro de Categoria");
    }

    public List<Categoria> getAllCategorias() {
        log.info("Buscando todas as categorias");
        return categoriaRepository.findAll();
    }

}
