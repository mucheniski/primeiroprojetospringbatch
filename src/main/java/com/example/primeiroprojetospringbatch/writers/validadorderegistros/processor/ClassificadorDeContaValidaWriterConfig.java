package com.example.primeiroprojetospringbatch.writers.validadorderegistros.processor;

import com.springbatch.contasbancarias.dominio.Conta;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassificadorDeContaValidaWriterConfig {

    @Bean
    public ClassifierCompositeItemWriter<Conta> classificadorDeContaValidaWriter(
            /**
             * Preciso colocar o qualifier porque já exite outro FlatFileItemWriter no projeto
             * ArquivoContaWriterConfig
             */
            @Qualifier("clienteInvalidoWriter") FlatFileItemWriter<Conta> clienteInvalidoWriter,
            CompositeItemWriter<Conta> escritorCompostoWriter
    ) {
        return new ClassifierCompositeItemWriterBuilder<Conta>()
                .classifier(classificador(clienteInvalidoWriter, escritorCompostoWriter))
                .build();
    }

    private Classifier<Conta, ItemWriter<? super Conta>> classificador(FlatFileItemWriter<Conta> clienteInvalidoWriter, CompositeItemWriter<Conta> escritorCompostoWriter) {

        return new Classifier<Conta, ItemWriter<? super Conta>>() {

            @Override
            public ItemWriter<? super Conta> classify(Conta conta) {
                if (conta.getTipo() != null)
                    return escritorCompostoWriter;
                else
                    return clienteInvalidoWriter;
            }
        };

    }

}
