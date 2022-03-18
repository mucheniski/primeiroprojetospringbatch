package com.example.primeiroprojetospringbatch.domain;

import lombok.Data;

@Data
public class Transacao {

    private String id;
    private String descricao;
    private Double valor;

}
