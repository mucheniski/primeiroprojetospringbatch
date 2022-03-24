package com.example.primeiroprojetospringbatch.processors.classificador.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ProcessadorClassifierReaderConfig {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FlatFileItemReader processadorClassifierReader(LineMapper lineMapper) {

		FileSystemResource resource = new FileSystemResource("/home/developer/ws-developer/spring-batch/ProcessadorClassifierJob/files/clientes.txt");

		return new FlatFileItemReaderBuilder()
				.name("processadorClassifierReader")
				.resource(resource)
				.lineMapper(lineMapper).build();

	}

}
