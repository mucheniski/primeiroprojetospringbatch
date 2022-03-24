package com.example.primeiroprojetospringbatch.processors.classificador.processor;

import com.springbatch.processadorclassifier.dominio.Cliente;
import org.springframework.batch.item.ItemProcessor;

public class ProcessadorDeCliente implements ItemProcessor<Cliente, Cliente> {

    @Override
    public Cliente process(Cliente cliente) throws Exception {
        System.out.printf(String.format("\n Aplicando regras de negocio ao cliente %s", cliente.getNome()));
        return cliente;
    }
}
