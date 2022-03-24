package com.example.primeiroprojetospringbatch.processors.contasbancarias.reader;

import com.example.contasbancarias.domain.Cliente;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class ContasBancariasJdbcReaderConfig {

    @Bean
    public JdbcCursorItemReader<Cliente> contasBancariasReader(@Qualifier("applicationDataSource")DataSource dataSource) {

        return new JdbcCursorItemReaderBuilder<Cliente>()
                .name("contasBancariasReader")
                .dataSource(dataSource)
                .sql("select * from cliente")
                .rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
                .build();
    }

}
