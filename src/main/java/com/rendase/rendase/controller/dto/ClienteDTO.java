package com.rendase.rendase.controller.dto;

import com.rendase.rendase.domain.Endereco;
import lombok.Data;

@Data
public class ClienteDTO {

    private Long id;
    private String nome;
    private Endereco endereco;
    private String contato;
}

