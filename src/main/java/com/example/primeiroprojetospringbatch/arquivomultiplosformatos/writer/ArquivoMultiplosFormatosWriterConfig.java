package com.example.primeiroprojetospringbatch.arquivomultiplosformatos.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoMultiplosFormatosWriterConfig {

    @Bean
    public ItemWriter arquivoMultiplosFormatosWriter() {
        return items -> items.forEach(System.out::println);
    }

}
