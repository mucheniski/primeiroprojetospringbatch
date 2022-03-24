package com.example.primeiroprojetospringbatch.processors.contasbancarias.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("ALL")
@Configuration
public class ClassificadorContasBancariasProcessorConfig {

    @Bean
    public ItemProcessor classificadorContasBancariasProcessor() {

        return new ClassifierCompositeItemProcessorBuilder<>()
                .classifier(classificadorDeContas())
                .build();

    }

    private Classifier classificadorDeContas() {

        return new Classifier<Object, ItemProcessor>() {

            @Override
            public ItemProcessor classify(Object objetoRetornado) {
                return new ValidarFaixaSalarial();
            }

        };

    }

}
