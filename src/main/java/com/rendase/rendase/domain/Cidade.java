package com.rendase.rendase.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
}