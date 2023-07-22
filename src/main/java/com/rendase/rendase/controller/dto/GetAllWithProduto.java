package com.rendase.rendase.controller.dto;

import com.rendase.rendase.domain.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllWithProduto {

    private Long id;
    private String descricao;
    private Categoria categoria;
    private String cor;
    private BigDecimal preco;
    private String tamanho;
    private String sexo;

}
