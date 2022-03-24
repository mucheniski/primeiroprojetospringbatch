package com.example.primeiroprojetospringbatch.processors.executascript.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.springbatch.processadorscript.dominio.Cliente;

@Configuration
public class ProcessadorScriptReaderConfig {

	@Bean
	public FlatFileItemReader<Cliente> processadorScriptReader() {

		FileSystemResource resource = new FileSystemResource("/home/developer/ws-developer/spring-batch/ProcessadorScriptJob/files/clientes.txt");

		return new FlatFileItemReaderBuilder<Cliente>()
				.name("processadorScriptReader")
				.resource(resource)
				.delimited()
				.names("nome", "idade", "email")
				.targetType(Cliente.class)
				.build();
	}
}
