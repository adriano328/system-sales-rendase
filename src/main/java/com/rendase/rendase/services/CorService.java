package com.rendase.rendase.services;

import com.rendase.rendase.domain.Categoria;
import com.rendase.rendase.domain.Cor;
import com.rendase.rendase.exception.NotFoundException;
import com.rendase.rendase.repositories.CorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CorService {

    final private CorRepository corRepository;

    @Transactional
    public void save(Cor cor) {
        corRepository.save(cor);
        log.info("Cadastrando Cor");
    }

    public Cor getById(Long id) {
        log.info("Buscando Cor");
        return corRepository.findById(id).orElseThrow(() -> new NotFoundException("Cor não localizada!"));
    }

    public List<Cor> getAllCor() {
        log.info("Buscando todas as categorias");
        return corRepository.findAll();
    }
}
