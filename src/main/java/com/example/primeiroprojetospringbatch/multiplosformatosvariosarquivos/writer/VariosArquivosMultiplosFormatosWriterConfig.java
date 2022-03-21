package com.example.primeiroprojetospringbatch.multiplosformatosvariosarquivos.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VariosArquivosMultiplosFormatosWriterConfig {

    @Bean
    public ItemWriter variosArquivoMultiplosFormatosWriter() {
        return items -> items.forEach(System.out::println);
    }

}
