package com.rendase.rendase.controller.dto;

import com.rendase.rendase.domain.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllWithProduto {

    private String descricao;
    private Categoria categoria;
    private String cor;
    private double preco;
    private String tamanho;
    private String sexo;

}
