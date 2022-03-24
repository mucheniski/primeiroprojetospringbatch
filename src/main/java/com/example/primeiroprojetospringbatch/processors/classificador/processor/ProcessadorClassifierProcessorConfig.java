package com.example.primeiroprojetospringbatch.processors.classificador.processor;

import com.springbatch.processadorclassifier.dominio.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.ClassifierCompositeItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessadorClassifierProcessorConfig {
	@SuppressWarnings("rawtypes")
	@Bean
	public ItemProcessor processadorClassifierProcessor() {

		/*
		* Faz uma tratativa dependendo do tipo de objeto, pela classificação
		*
		* */
		return new ClassifierCompositeItemProcessorBuilder<>()
				.classifier(classificador())
				.build();

	}

	private Classifier classificador() {

		/*
		* Recebe um objato e dependendo do objeto retorna um ItemProcessor específico
		* */
		return new Classifier<Object, ItemProcessor>() {

			@Override
			public ItemProcessor classify(Object objetoLido) {
				if (objetoLido instanceof Cliente)
					return new ProcessadorDeCliente();
				else
					return new ProcessadorDeTransacao();
			}
		};

	}
}
