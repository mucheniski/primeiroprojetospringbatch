package com.example.primeiroprojetospringbatch.processor.validadorcomposto.processor;

import com.springbatch.processadorvalidacao.dominio.ClienteValidation;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.CompositeItemProcessorBuilder;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ProcessadorValidacaoProcessorConfig {

	private Set<String> emails = new HashSet<>();

	/*
	* Como é um Bean, no step ele já esta sendo injetado, entao o spring encontra o processador
	* */
	@Bean
	public ItemProcessor<ClienteValidation, ClienteValidation> procesadorValidacaoProcessor() throws Exception {
		return new CompositeItemProcessorBuilder<ClienteValidation, ClienteValidation>()
				.delegates(validadorAnotacoesSpring(), validadorDeEmailRepetido()) // Delega a validação para os dois processadores, é um validador composto, agora faz as duas validações
				.build();

	}

	private BeanValidatingItemProcessor<ClienteValidation> validadorAnotacoesSpring() throws Exception {
		/*
		 * Como já tem as validacoes do spring na classe cliente, fazendo isso o processador já verifica todas
		 * */
		BeanValidatingItemProcessor<ClienteValidation> processor = new BeanValidatingItemProcessor<>();
		processor.setFilter(true);
		processor.afterPropertiesSet(); // Seta as propriedades do validador, por ser composto
		return processor;
	}

	// Esse é para uma validação mais customizada, pode ser usado esse ou o de cima.
	private ValidatingItemProcessor<ClienteValidation> validadorDeEmailRepetido() {
		ValidatingItemProcessor<ClienteValidation> processor = new ValidatingItemProcessor<>();
		processor.setValidator(validadorCustomizado());
		processor.setFilter(true); // Faz com que não de falha na execução do batch, apenas retira os objetos que estiverem fora das validações colocadas na classe ClienteValidation
		return processor;
	}

	private Validator<ClienteValidation> validadorCustomizado() {

		return new Validator<ClienteValidation>() {
			@Override
			public void validate(ClienteValidation clienteValidation) throws ValidationException {

				// Verifica se existem e-mails duplicados
				if (emails.contains(clienteValidation.getEmail()))
					throw new ValidationException(String.format("O cliente %s ja foi processado", clienteValidation.getEmail()));
				emails.add(clienteValidation.getEmail());
			}
		};

	}
}
