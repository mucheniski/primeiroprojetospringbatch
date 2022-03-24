package com.example.primeiroprojetospringbatch.processors.contasbancarias.processor;

import com.example.primeiroprojetospringbatch.processors.contasbancarias.domain.Cliente;
import com.example.primeiroprojetospringbatch.processors.contasbancarias.domain.Conta;
import com.example.primeiroprojetospringbatch.processors.contasbancarias.domain.enums.TipoContaEnum;
import org.springframework.batch.item.ItemProcessor;

import java.util.concurrent.ThreadLocalRandom;

public class ValidarFaixaSalarial implements ItemProcessor<Cliente, Conta> {

    @Override
    public Conta process(Cliente cliente) throws Exception {

        TipoContaEnum tipo = TipoContaEnum.NAO_INFORMADO;
        Double limite = 0.0;
        Double faixaSalarial = cliente.getFaixaSalarial();

        if (faixaSalarial <= 3000) {
            tipo = TipoContaEnum.PRATA;
            limite = 500.0;
        } else if (faixaSalarial > 3000 && faixaSalarial <= 5000) {
            tipo = TipoContaEnum.OURO;
            limite = 1000.0;
        } else if (faixaSalarial > 5000 && faixaSalarial <= 10000) {
            tipo = TipoContaEnum.PLATINA;
            limite = 2500.0;
        } else if (faixaSalarial > 10000) {
            tipo = TipoContaEnum.DIAMANTE;
            limite = 5000.0;
        }

        return instanciaConta(cliente.getEmail(), tipo, limite);

    }

    private Conta instanciaConta(String clienteEmail, TipoContaEnum tipo, Double limite) {
        Conta conta = new Conta();
        conta.setId(ThreadLocalRandom.current().nextInt());
        conta.setCliente_id(clienteEmail);
        conta.setTipo(tipo);
        conta.setLimite(limite);
        return conta;
    }
}
