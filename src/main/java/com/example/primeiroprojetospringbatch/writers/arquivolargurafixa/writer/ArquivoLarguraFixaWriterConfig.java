package com.example.primeiroprojetospringbatch.writers.arquivolargurafixa.writer;

import com.example.primeiroprojetospringbatch.writers.arquivolargurafixa.dominio.Cliente;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ArquivoLarguraFixaWriterConfig {

	/*
	* FlatFileItemReader escreve arquivos formatados, independente do formato, delimitado, largura fixa, etc
	* */

	@Bean
	public FlatFileItemWriter<Cliente> escritaArquivoLarguraFixaWriter() {

		FileSystemResource arquivoEscrita = new FileSystemResource("/home/developer/ws-developer/spring-batch/ArquivoLarguraFixaJob/files/clientesSaida.txt");

		return new FlatFileItemWriterBuilder<Cliente>()
				.name("escritaArquivoLarguraFixaWriter")
				.resource(arquivoEscrita)
				.formatted()
//				.columns(new Range[]{new Range(1,10), new Range(11, 20), new Range(21, 23), new Range(24, 43)})
				.format("%-9s %-9s %-2s %-19s") // Formato retirado dos ranges acima, sempre tem o mesmo tamanho, completado com espacos new Range(1,10) igual 9 espacos
				.names("nome", "sobrenome", "idade", "email") // Nomas das colunas
				.build();
	}
}
