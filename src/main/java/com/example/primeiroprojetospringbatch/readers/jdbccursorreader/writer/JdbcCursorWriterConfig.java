package com.example.primeiroprojetospringbatch.readers.jdbccursorreader.writer;

import com.example.primeiroprojetospringbatch.domain.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JdbcCursorWriterConfig {
	@Bean
	public ItemWriter<Cliente> jdbcCursorWriter() {
		return clientes -> clientes.forEach(System.out::println);
	}
}
