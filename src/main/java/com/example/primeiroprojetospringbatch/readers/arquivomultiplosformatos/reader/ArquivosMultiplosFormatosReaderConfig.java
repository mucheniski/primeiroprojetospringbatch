package com.example.primeiroprojetospringbatch.readers.arquivomultiplosformatos.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@SuppressWarnings("ALL")
@Configuration
public class ArquivosMultiplosFormatosReaderConfig {

    @Bean
    public FlatFileItemReader arquivoMultiplosFormatosReader(LineMapper lineMapper) {

        FileSystemResource pathLocation = new FileSystemResource("C:\\ws-developer\\spring-java\\primeiroprojetospringbatch\\externalizada\\clientesTransacoes.txt");

        return new FlatFileItemReaderBuilder()
                .name("arquivoMultiplosFormatosReader")
                .resource(pathLocation)
                .lineMapper(lineMapper) // Não passamos o tipo porque o arquivo é de vários tipos
                .build();
    }

}
