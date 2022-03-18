package com.example.primeiroprojetospringbatch.arquivolargurafixa.step;

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
    public Step arquivoLarguraFixaStep(ItemReader<Cliente> arquivoLarguraFixaReader, ItemWriter<Cliente> arquivoLarguraFixaWriter) {
        return stepBuilderFactory
                .get("arquivoLarguraFixaStep")
                .<Cliente, Cliente>chunk(1) // Le Cliente e escreve Cliente
                .reader(arquivoLarguraFixaReader)
                .writer(arquivoLarguraFixaWriter)
                .build();
    }

}
