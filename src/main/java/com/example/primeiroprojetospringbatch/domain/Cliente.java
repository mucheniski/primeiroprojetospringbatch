package com.example.primeiroprojetospringbatch.domain;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente {

    private String nome;
    private String sobrenome;
    private String idade;
    private String email;
    private List<Transacao> transacoes = new ArrayList<>();

    public void addTrancacao(Transacao transacao) {
        transacoes.add(transacao);
    }

}
