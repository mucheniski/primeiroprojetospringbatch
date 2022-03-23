package com.example.primeiroprojetospringbatch.processor.step;

import com.example.primeiroprojetospringbatch.domain.ClienteValidation;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ProcessadorValidacaoStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step processadorValidacaoStep(
			ItemReader<ClienteValidation> processadorValidacaoReader,
			ItemProcessor<ClienteValidation, ClienteValidation> processadorValidacaoProcessor,
			ItemWriter<ClienteValidation> processadorValidacaoWriter
	) {
		return stepBuilderFactory
				.get("processadorValidacaoStep")
				.<ClienteValidation, ClienteValidation>chunk(1)
				.reader(processadorValidacaoReader)
				.processor(processadorValidacaoProcessor)
				.writer(processadorValidacaoWriter)
				.build();
	}
}
