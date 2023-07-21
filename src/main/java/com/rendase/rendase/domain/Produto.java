package com.rendase.rendase.domain;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "cliente")
public class Produto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @OneToOne
    @JoinColumn(name = "categoriaid")
    private Categoria categoria;

    @Column(name = "cor")
    private String cor;

    @Column(name = "preco")
    private double preco;

    @Column(name = "tamanho")
    private String tamanho;

    @Column(name = "sexo")
    private String sexo;


}
