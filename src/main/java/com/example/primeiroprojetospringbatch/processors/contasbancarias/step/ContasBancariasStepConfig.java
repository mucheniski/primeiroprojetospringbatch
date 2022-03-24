package com.example.primeiroprojetospringbatch.processors.contasbancarias.step;

import com.example.contasbancarias.domain.Cliente;
import com.example.contasbancarias.domain.Conta;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("ALL")
@Configuration
public class ContasBancariasStepConfig {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step contaBancariaStep(
            ItemReader<Cliente> contasBancariasReader,
            ItemProcessor classificadorContasBancariasProcessor,
            ItemWriter<Conta> contasBancariasWriter
    ) {
        return stepBuilderFactory
                .get("contaBancariaStep")
                .<Cliente, Cliente>chunk(1)
                .reader(contasBancariasReader)
                .processor(classificadorContasBancariasProcessor)
                .writer(contasBancariasWriter)
                .build();
    }

}
