package com.example.primeiroprojetospringbatch.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@EnableBatchProcessing // Permite que a injete e utilize componentes do framework spring batch
@Configuration
public class ImprimeOlaJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job imprimeOlaJob(Step imprimeOlaStep) {

        log.info("");
        log.info("=============================== IMPRIMINDO JOB imprimeOlaJob ===============================");
        log.info("");

        return jobBuilderFactory
                .get("imprimeOlaJob")
                .start(imprimeOlaStep)
                .incrementer(new RunIdIncrementer()) // Serve para podermos executar o mesmo job mais de uma vez, incrementando o id para diferenciar
                .build();
    }

}
