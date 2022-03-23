package com.example.primeiroprojetospringbatch.readers.multiplosformatosvariosarquivos.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;


@Configuration
public class MultiplosArquivosReaderConfig {

    FileSystemResource pathLocation1 = new FileSystemResource("C:\\ws-developer\\spring-java\\primeiroprojetospringbatch\\externalizada\\clientesNTransacoes1");
    FileSystemResource pathLocation2 = new FileSystemResource("C:\\ws-developer\\spring-java\\primeiroprojetospringbatch\\externalizada\\clientesNTransacoes2");
    FileSystemResource pathLocation3 = new FileSystemResource("C:\\ws-developer\\spring-java\\primeiroprojetospringbatch\\externalizada\\clientesNTransacoes3");


    @Bean
    public MultiResourceItemReader multiplosArquivosReader(FlatFileItemReader arquivosMultiplosFormatosReaderConfig) {

        return new MultiResourceItemReaderBuilder<>()
                .name("multiplosArquivosReader")
                .resources(pathLocation1, pathLocation2, pathLocation3)
                .delegate(new VariosArquivosClienteTransacaoReader(arquivosMultiplosFormatosReaderConfig))
                .build();

    }

}
