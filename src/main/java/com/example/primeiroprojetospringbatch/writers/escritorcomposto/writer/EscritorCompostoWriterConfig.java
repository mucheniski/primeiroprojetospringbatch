package com.example.primeiroprojetospringbatch.writers.escritorcomposto.writer;

import com.springbatch.contasbancarias.dominio.Conta;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.CompositeItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EscritorCompostoWriterConfig {

    @Bean
    CompositeItemWriter<Conta> escritorCompostoWriter(
         FlatFileItemWriter<Conta> arquivoContaWriter,
         JdbcBatchItemWriter<Conta> jdbcContaWriter
    ) {
        return new CompositeItemWriterBuilder<Conta>()
                .delegates(arquivoContaWriter, jdbcContaWriter) // Todos os escritores serao invocados na ordem passada aqui
                .build();
    }

}
