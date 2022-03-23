package com.example.primeiroprojetospringbatch.processor.validadorcomposto.writer;

import com.springbatch.processadorvalidacao.dominio.ClienteValidation;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.processadorvalidacao.dominio.Cliente;

@Configuration
public class ProcessadorValidacaoWriterConfig {
	@Bean
	public ItemWriter<ClienteValidation> processadorValidacaoWriter() {
		return clientes -> clientes.forEach(System.out::println);
	}
}
