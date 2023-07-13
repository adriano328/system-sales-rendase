package com.rendase.rendase.controller.dto;


import com.rendase.rendase.domain.Cidade;
import lombok.Data;

@Data
public class EnderecoDTO {
    private Long id;
    private String rua;
    private String bairro;
    private Integer numero;
    private Cidade cidade;
}

