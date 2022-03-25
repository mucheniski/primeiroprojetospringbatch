package com.example.primeiroprojetospringbatch.writers.validadorderegistros.writer;

import com.springbatch.contasbancarias.dominio.Conta;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.CompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EscritorCompostoWriterConfig {

    @Bean
    CompositeItemWriter<Conta> escritorCompostoWriter(
         @Qualifier("arquivoContaWriter") FlatFileItemWriter<Conta> arquivoContaWriter,
         JdbcBatchItemWriter<Conta> jdbcContaWriter
    ) {
        return new CompositeItemWriterBuilder<Conta>()
                .delegates(arquivoContaWriter, jdbcContaWriter) // Todos os escritores serao invocados na ordem passada aqui
                .build();
    }

}
