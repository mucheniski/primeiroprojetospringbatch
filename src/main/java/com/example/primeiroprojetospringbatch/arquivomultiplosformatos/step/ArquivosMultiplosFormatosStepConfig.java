package com.example.primeiroprojetospringbatch.arquivomultiplosformatos.step;

import com.example.primeiroprojetospringbatch.arquivomultiplosformatos.reader.ArquivoClienteTransacaoReader;
import com.example.primeiroprojetospringbatch.domain.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("ALL")
@Configuration
public class ArquivosMultiplosFormatosStepConfig {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step arquivosMultiplosFormatosStep(ItemReader arquivoMultiplosFormatosReader, ItemWriter arquivoMultiplosFormatosWriter) {
        return stepBuilderFactory
                .get("arquivosMultiplosFormatosStep")
                .<Cliente, Cliente>chunk(1)
                .reader(new ArquivoClienteTransacaoReader((ItemStreamReader<Object>) arquivoMultiplosFormatosReader))
                .writer(arquivoMultiplosFormatosWriter)
                .build();
    }

}
