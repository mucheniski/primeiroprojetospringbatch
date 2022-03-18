package com.example.primeiroprojetospringbatch.arquivolargurafixa.writer;

import com.example.primeiroprojetospringbatch.domain.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoLarguraFixaWriterConfig {

    @Bean
    public ItemWriter<Cliente> arquivoLarguraFixaWriter() {
        return clientes -> clientes.forEach(System.out::println);
    }

}
