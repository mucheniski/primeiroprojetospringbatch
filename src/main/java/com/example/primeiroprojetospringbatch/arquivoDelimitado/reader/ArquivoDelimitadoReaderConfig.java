package com.example.primeiroprojetospringbatch.arquivoDelimitado.reader;

import com.example.primeiroprojetospringbatch.domain.Cliente;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ArquivoDelimitadoReaderConfig {

    public FlatFileItemReader<Cliente> lerArquivoDelimitado() {

        FileSystemResource pathLocation = new FileSystemResource("C:\\ws-developer\\spring-java\\primeiroprojetospringbatch\\externalizada\\clientesDelimitado.txt");

        return new FlatFileItemReaderBuilder<Cliente>()
                .name("lerArquivoDelimitado")
                .resource(pathLocation)
                .delimited() // Tipo de arquivo delimitado
                .names(new String[]{"nome","sobrenome","idade","email"})
                .targetType(Cliente.class)
                .build();

    }

}
