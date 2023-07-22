package com.rendase.rendase.services;

import com.rendase.rendase.domain.Cor;
import com.rendase.rendase.domain.Tamanho;
import com.rendase.rendase.exception.NotFoundException;
import com.rendase.rendase.repositories.TamanhoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TamanhoService {

    private final TamanhoRepository tamanhoRepository;

    @Transactional
    public void save(Tamanho tamanho) {
        tamanhoRepository.save(tamanho);
        log.info("Cadastrando tamanho");
    }

    public Tamanho getById(Long id) {
        log.info("Buscando tamanho");
        return tamanhoRepository.findById(id).orElseThrow(() -> new NotFoundException("Cor não localizada!"));
    }

    public List<Tamanho> getAllCor() {
        log.info("Buscando todos os tamanhos");
        return tamanhoRepository.findAll();
    }
}
