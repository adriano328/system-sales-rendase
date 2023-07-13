package com.rendase.rendase.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rua")
    private String rua;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "numero")
    private Integer numero;

    @OneToOne
    @JoinColumn(name = "cidadeid")
    private Cidade cidade;
}