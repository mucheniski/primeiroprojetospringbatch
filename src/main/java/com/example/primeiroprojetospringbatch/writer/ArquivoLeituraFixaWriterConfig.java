package com.example.primeiroprojetospringbatch.writer;

import com.example.primeiroprojetospringbatch.domain.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoLeituraFixaWriterConfig {

    @Bean
    public ItemWriter<Cliente> arquivoLeituraFixaWriter() {
        return clientes -> clientes.forEach(System.out::println);
    }

}
