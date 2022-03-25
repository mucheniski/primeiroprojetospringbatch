package com.example.primeiroprojetospringbatch.writers.demonstrativoorcamentario.writer;

import com.springbatch.demonstrativoorcamentario.dominio.GrupoLancamento;
import org.springframework.batch.core.annotation.BeforeWrite;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.text.NumberFormat;
import java.util.List;

@Component
public class Rodape implements FlatFileFooterCallback {

    private Double totalGeral = 0.0;

    @Override
    public void writeFooter(Writer writer) throws IOException {
        writer.append(String.format("\t\t\t\t\t\t\t  Total: %s\n", NumberFormat.getCurrencyInstance().format(totalGeral)));
        writer.append(String.format("\t\t\t\t\t\t\t  Código de Autenticação: %s\n", "fkyew6868fewjfhjjewf"));
    }

    /**
     * @BeforeWrite faz com que o metodo fique acessivel no contesto do spring
     * é um listener que recebe uma lista do objeto sendo utilizado, esse listener
     * precisa ser registrado lá no configurador de step
     */
    @BeforeWrite
    public void beforeWrite(List<GrupoLancamento> grupos){
        for (GrupoLancamento grupoLancamento : grupos) {
            totalGeral += grupoLancamento.getTotal();
        }
    }

}
