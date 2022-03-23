package com.example.primeiroprojetospringbatch.readers.arquivoDelimitado.writer;

import com.example.primeiroprojetospringbatch.domain.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoDelimitadoWriterConfig {

    @Bean
    public ItemWriter<Cliente> arquivoDelimitadoWriter() {
        return clientes -> clientes.forEach(System.out::println);
    }

}
