package com.example.primeiroprojetospringbatch.processors.classificador.processor;

import com.example.primeiroprojetospringbatch.domain.Transacao;
import org.springframework.batch.item.ItemProcessor;

public class ProcessadorDeTransacao implements ItemProcessor<Transacao, Transacao> {

    @Override
    public Transacao process(Transacao transacao) throws Exception {
        System.out.printf(String.format("\n Aplicando regras de negocio ao transacao %s", transacao.getDescricao()));
        return transacao;
    }
}
