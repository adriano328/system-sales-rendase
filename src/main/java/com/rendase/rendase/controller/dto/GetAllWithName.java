package com.rendase.rendase.controller.dto;

import com.rendase.rendase.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllWithName {
    private Long id;
    private String nome;
    private String contato;
}

