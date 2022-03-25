package com.example.primeiroprojetospringbatch.writers.validadorderegistros.writer;

import com.springbatch.contasbancarias.dominio.Conta;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ClienteInvalidoWriterConfig {

    FileSystemResource resource = new FileSystemResource("./files/clientesInvalidos.txt");

    @Bean
    public FlatFileItemWriter<Conta> clienteInvalidoWriter() {
        return new FlatFileItemWriterBuilder<Conta>()
                .name("clienteInvalidoWriter")
                .resource(resource)
                .delimited()
                .names("clienteId")
                .build();
    }
}
