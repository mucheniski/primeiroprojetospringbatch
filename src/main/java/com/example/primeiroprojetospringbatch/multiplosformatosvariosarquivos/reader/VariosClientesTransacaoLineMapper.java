package com.example.primeiroprojetospringbatch.multiplosformatosvariosarquivos.reader;

import com.example.primeiroprojetospringbatch.domain.Cliente;
import com.example.primeiroprojetospringbatch.domain.Transacao;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ALL")
@Configuration
public class VariosClientesTransacaoLineMapper {

    @Bean
    public PatternMatchingCompositeLineMapper variosArquivosLineMapper() {
        PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper<>();
        lineMapper.setTokenizers(tokenizers()); // Pega as linhas e divide em palavas
        lineMapper.setFieldSetMappers(fieldSetMappers()); // Pega as palavras e mapeia para objetos de domínio
        return lineMapper;
    }

    private Map<String, LineTokenizer> tokenizers() {
        Map<String, LineTokenizer> tokenizersMap = new HashMap<>();
        tokenizersMap.put("C*", clienteLineTokenizer()); // Começando com C qualquer coisa depois é cliente
        tokenizersMap.put("T*", transacaoLineTokenizer()); // Começando com T qualquer coisa depois é Transação
        return tokenizersMap;
    }

    private LineTokenizer clienteLineTokenizer() {
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("nome", "sobrenome", "idade", "email");
        lineTokenizer.setIncludedFields(1, 2, 3, 4); // Inicio do 1 porque o 0 é só oC que é o tipo da linha
        return lineTokenizer;
    }

    private LineTokenizer transacaoLineTokenizer() {
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("id", "descricao", "valor");
        lineTokenizer.setIncludedFields(1, 2, 3);
        return lineTokenizer;
    }

    private Map<String, FieldSetMapper> fieldSetMappers() {
        Map<String, FieldSetMapper> fieldSetMappers = new HashMap<>();
        fieldSetMappers.put("C*", fieldSetMapper(Cliente.class));
        fieldSetMappers.put("T*", fieldSetMapper(Transacao.class));
        return fieldSetMappers;
    }

    private FieldSetMapper fieldSetMapper(Class classe) {
        BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(classe);
        return fieldSetMapper;
    }

}
