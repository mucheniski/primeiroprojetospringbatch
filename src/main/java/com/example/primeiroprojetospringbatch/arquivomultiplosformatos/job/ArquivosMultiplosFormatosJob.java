package com.example.primeiroprojetospringbatch.arquivomultiplosformatos.job;

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
@EnableBatchProcessing
@Configuration
public class ArquivosMultiplosFormatosJob {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job arquivosMultiplosFormatosJobConfig(Step arquivosMultiplosFormatosStep) {

        log.info("");
        log.info("=============================== IMPRIMINDO JOB arquivosMultiplosFormatosJobConfig ===============================");
        log.info("");

        return jobBuilderFactory
                .get("jobBuilderFactory")
                .start(arquivosMultiplosFormatosStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
