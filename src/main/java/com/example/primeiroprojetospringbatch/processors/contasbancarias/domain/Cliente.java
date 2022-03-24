package com.example.primeiroprojetospringbatch.processors.contasbancarias.domain;

import lombok.Data;

@Data
public class Cliente {

    private String nome;
    private Integer idade;
    private String email;
    private Double faixaSalarial;

}
