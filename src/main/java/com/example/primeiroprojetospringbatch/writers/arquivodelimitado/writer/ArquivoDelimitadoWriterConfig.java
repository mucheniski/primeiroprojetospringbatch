package com.example.primeiroprojetospringbatch.writers.arquivodelimitado.writer;

import com.example.primeiroprojetospringbatch.writers.arquivodelimitado.dominio.Cliente;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ArquivoDelimitadoWriterConfig {

	@Bean
	public FlatFileItemWriter<Cliente> arquivoDelimitadoWriter() {

		FileSystemResource resource = new FileSystemResource("/home/developer/ws-developer/spring-batch/ArquivoDelimitadoJob/files/clienteSaida.txt");

		return new FlatFileItemWriterBuilder<Cliente>()
				.name("arquivoDelimitadoWriter")
				.resource(resource)
				.delimited()
				.delimiter(";") // Pode ser colocado qualquer delimitador para o arquivo de saída
				.names("nome", "sobrenome", "idade", "email")
				.build();

	}

}
