package com.rendase.rendase.services;


import com.rendase.rendase.controller.dto.ClienteDTO;
import com.rendase.rendase.controller.dto.GetAllWithName;
import com.rendase.rendase.domain.Cliente;
import com.rendase.rendase.exception.NotFoundException;
import com.rendase.rendase.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.util.Objects.isNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;
    private final EnderecoService enderecoService;

    @Transactional
    public void salvar(ClienteDTO clienteDTO) {
        Cliente cliente = Cliente.builder()
                .nome(clienteDTO.getNome())
                .cpf(clienteDTO.getCpf())
                .contato(clienteDTO.getContato())
                .endereco(clienteDTO.getEndereco())
                .build();
        clienteRepository.save(cliente);
        log.info("Cadastrando cliente");
    }

    public Cliente getById(Long id) {
        log.info("Buscando cliente");
        return clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Cliente não localizado!"));
    }

    @Transactional
    public void delete(Long id) {
        Cliente clienteToDelete = getById(id);
        clienteRepository.delete(clienteToDelete);
        log.info("Deletando cliente");
    }

    @Transactional
    public void alterar(final ClienteDTO clienteDTO) {
        if (!isNull(clienteDTO.getEndereco())) {
            enderecoService.save(clienteDTO.getEndereco());
        }
        clienteRepository.save(modelMapper.map(clienteDTO, Cliente.class));
        log.info("Alterando cadastro de cliente");
    }

    public Page<GetAllWithName> getAllWithName(String nome, Pageable pageable) {
        log.info("Buscando todos os clientes por nome");
        return clienteRepository.getAllWithName(nome, pageable);
    }
}