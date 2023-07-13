package com.rendase.rendase.services;

import com.rendase.rendase.controller.dto.EnderecoDTO;
import com.rendase.rendase.domain.Endereco;
import com.rendase.rendase.exception.NotFoundException;
import com.rendase.rendase.repositories.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ModelMapper modelMapper;

    public void save(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public EnderecoDTO getById(Long id) {
        return modelMapper.map(enderecoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Endereco não encontrado.")), EnderecoDTO.class);
    }

    public void delete(Long id) {
        EnderecoDTO enderecoToRemove = getById(id);
        enderecoRepository.delete(modelMapper.map(enderecoToRemove, Endereco.class));
    }
}