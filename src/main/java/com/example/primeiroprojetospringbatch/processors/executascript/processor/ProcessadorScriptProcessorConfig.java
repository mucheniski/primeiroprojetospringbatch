package com.example.primeiroprojetospringbatch.processors.executascript.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ScriptItemProcessorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.processadorscript.dominio.Cliente;

@Configuration
public class ProcessadorScriptProcessorConfig {
	@Bean
	public ItemProcessor<Cliente, Cliente> processadorScriptProcessor() {

		/*
		* o Item é o objeto sendo recebido no procesador, no nosso caso um cliente
		* Esse script ignora o arquivo que é gerado no processamento com o nome do email do cliente
		* precisa ser passado o VM argument -Dnashorn.args=scripting para o script funcionar
		* */
		String script = " var email = item.getEmail();" +
						" var arquivoExiste = `ls | grep ${email}.txt`;" +
						" if (!arquivoExiste) item: else null;";

		return new ScriptItemProcessorBuilder<Cliente, Cliente>()
				.language("nashorn")
				.scriptSource(script) // Resource se fosse um arquivo, Source a string que representa o script
				.build();
	}
}
