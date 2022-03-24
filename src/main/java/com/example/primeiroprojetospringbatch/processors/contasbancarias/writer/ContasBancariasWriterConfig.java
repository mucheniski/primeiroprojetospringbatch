package com.example.primeiroprojetospringbatch.processors.contasbancarias.writer;

import com.example.contasbancarias.domain.Conta;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContasBancariasWriterConfig {

    @Bean
    public ItemWriter<Conta> contasBancariasWriter() {
        return contas -> contas.forEach(System.out::println);
    }

}
