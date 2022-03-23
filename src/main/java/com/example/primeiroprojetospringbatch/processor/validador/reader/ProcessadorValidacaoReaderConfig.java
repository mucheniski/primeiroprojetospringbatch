package com.example.primeiroprojetospringbatch.processor.validador.reader;

import com.example.primeiroprojetospringbatch.domain.ClienteValidation;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


@Configuration
public class ProcessadorValidacaoReaderConfig {

	@Bean
	public FlatFileItemReader<ClienteValidation> processadorValidacaoReader() {

		FileSystemResource resource = new FileSystemResource("/home/developer/ws-developer/spring-batch/ProcessadorValidacaoJob/files/clientes.txt");

		return new FlatFileItemReaderBuilder<ClienteValidation>()
				.name("processadorValidacaoReader")
				.resource(resource)
				.delimited()
				.names("nome", "idade", "email")
				.targetType(ClienteValidation.class)
				.build();
	}
}
