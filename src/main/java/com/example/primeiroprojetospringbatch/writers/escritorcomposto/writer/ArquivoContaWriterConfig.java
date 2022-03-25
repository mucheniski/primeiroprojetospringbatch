package com.example.primeiroprojetospringbatch.writers.escritorcomposto.writer;

import com.springbatch.contasbancarias.dominio.Conta;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ArquivoContaWriterConfig {

    FileSystemResource resource = new FileSystemResource("./files/cliente.txt");

    @Bean
    public FlatFileItemWriter<Conta> arquivoContaWriter() {
        return new FlatFileItemWriterBuilder<Conta>()
                .name("arquivoContaWriter")
                .resource(resource)
                .delimited()
                .names("tipo", "limite", "clienteId")
                .build();
    }

}
