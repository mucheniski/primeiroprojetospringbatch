package com.example.primeiroprojetospringbatch.processor.validador.writer;

import com.example.primeiroprojetospringbatch.domain.ClienteValidation;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ProcessadorValidacaoWriterConfig {
	@Bean
	public ItemWriter<ClienteValidation> processadorValidacaoWriter() {
		return clientes -> clientes.forEach(System.out::println);
	}
}
