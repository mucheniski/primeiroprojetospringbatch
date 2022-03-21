package com.example.primeiroprojetospringbatch.multiplosformatosvariosarquivos.step;

import com.example.primeiroprojetospringbatch.domain.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("ALL")
@Configuration
public class VariosArquivosMultiplosFormatosStepConfig {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step variosArquivosMultiplosFormatosStep(MultiResourceItemReader<Cliente> multiplosArquivosReader, ItemWriter arquivoMultiplosFormatosWriter) {
        return stepBuilderFactory
                .get("arquivosMultiplosFormatosStep")
                .<Cliente, Cliente>chunk(1)
                .reader(multiplosArquivosReader)
                .writer(arquivoMultiplosFormatosWriter)
                .build();
    }

}
