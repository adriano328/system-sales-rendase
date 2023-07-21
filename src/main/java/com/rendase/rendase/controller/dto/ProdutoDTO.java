package com.rendase.rendase.controller.dto;

import com.rendase.rendase.domain.Categoria;
import lombok.Data;

import javax.persistence.*;

@Data
public class ProdutoDTO {

    private Long id;
    private String descricao;
    private Categoria categoria;
    private String cor;
    private double preco;
    private String tamanho;
    private String sexo;
}
