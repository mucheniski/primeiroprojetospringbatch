package com.example.primeiroprojetospringbatch.step;

import com.example.primeiroprojetospringbatch.domain.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoLarguraFixaStepConfig {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step ArquivoLarguraFixaStep(ItemReader<Cliente> arquivoLarguraFixaReader, ItemWriter<Cliente> arquivoLarguraFixaWriter) {
        return stepBuilderFactory
                .get("ArquivoLarguraFixaStep")
                .<Cliente, Cliente>chunk(1) // Le Cliente e escreve Cliente
                .reader(arquivoLarguraFixaReader)
                .writer(arquivoLarguraFixaWriter)
                .build();
    }

}