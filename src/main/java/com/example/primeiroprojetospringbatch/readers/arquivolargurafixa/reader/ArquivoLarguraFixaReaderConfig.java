package com.example.primeiroprojetospringbatch.readers.arquivolargurafixa.reader;

import com.example.primeiroprojetospringbatch.domain.Cliente;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ArquivoLarguraFixaReaderConfig {

    @Bean
    public FlatFileItemReader<Cliente> arquivoLarguraFixaReader() {

        /*
        * Os valores dos ranges são retirados do arquivo cleintesLarguraFixa.txt
        * */
        Range nome = new Range(1,11);  // Contando com o 1 mais 11 caracteres...
        Range sobrenome = new Range(12,26); // contando com o 12 mais 15 caracteres
        Range idade = new Range(27, 30); // Contando com o 27 mais 4 caracteres
        Range email = new Range(31, 45); // Contando com o 31 mais 14 caracteres
        Range[] colunas = new Range[]{nome, sobrenome, idade, email};

        FileSystemResource pathLocation = new FileSystemResource("C:\\ws-developer\\spring-java\\primeiroprojetospringbatch\\externalizada\\clientesLarguraFixa.txt");

        return new FlatFileItemReaderBuilder<Cliente>()
                .name("arquivoLarguraFixaReader")
                .resource(pathLocation)
                .fixedLength() // Tipo de arquivo largura fixa
                .columns(colunas)
                .names(new String[] {"nome", "sobrenome", "idade", "email"})
                .targetType(Cliente.class)
                .build();

    }

}
