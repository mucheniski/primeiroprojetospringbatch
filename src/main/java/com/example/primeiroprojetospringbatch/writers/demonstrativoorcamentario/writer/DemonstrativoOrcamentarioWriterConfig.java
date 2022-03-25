package com.example.primeiroprojetospringbatch.writers.demonstrativoorcamentario.writer;

import java.io.IOException;
import java.io.Writer;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.demonstrativoorcamentario.dominio.GrupoLancamento;
import com.springbatch.demonstrativoorcamentario.dominio.Lancamento;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class DemonstrativoOrcamentarioWriterConfig {

	@Bean
	public FlatFileItemWriter<GrupoLancamento> demonstrativoOrcamentarioWriter(Rodape rodape) {

		FileSystemResource resource = new FileSystemResource("/home/developer/ws-developer/spring-batch/DemonstrativoOrcamentarioJob/files/demonstrativo-custom.txt");

		return new FlatFileItemWriterBuilder<GrupoLancamento>()
				.name("demonstrativoOrcamentarioWriter")
				.resource(resource)
				.lineAggregator(formataLinhasArquivo()) // vai definir a logica de como vou obter dados do objeto lido e colocar na linha do arquivo de saida
				.headerCallback(cabecalho()) // Cabeçalho
				.footerCallback(rodape) // rodape
				.build();
	}

	private FlatFileHeaderCallback cabecalho() {
		return new FlatFileHeaderCallback() {

			@Override
			public void writeHeader(Writer writer) throws IOException {
				writer.append(String.format("SISTEMA INTEGRADO: XPTO \t\t\t\t DATA: %s\n", new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
				writer.append(String.format("MÓDULO: ORÇAMENTO \t\t\t\t\t HORA: %s\n", new SimpleDateFormat("HH:MM").format(new Date())));
				writer.append(String.format("\t\t\tDEMONSTRATIVO ORCAMENTARIO\n"));
				writer.append(String.format("----------------------------------------------------------------------------\n"));
				writer.append(String.format("CODIGO NOME VALOR\n"));
				writer.append(String.format("\t Data Descricao Valor\n"));
				writer.append(String.format("----------------------------------------------------------------------------\n"));
			}
		};
	}

	private LineAggregator<GrupoLancamento> formataLinhasArquivo() {

		return new LineAggregator<GrupoLancamento>() {

			@Override
			public String aggregate(GrupoLancamento grupoLancamento) {

				// Retorno o grupo lançamento
				String grupoLancamentoFormatado = String.format(
						"[%d] %s - %s\n",
						grupoLancamento.getCodigoNaturezaDespesa(),
						grupoLancamento.getDescricaoNaturezaDespesa(),
						NumberFormat.getCurrencyInstance().format(grupoLancamento.getTotal())
				);

				StringBuilder stringBuilder = new StringBuilder();

				// Para cada lançamento no grupo retorno uma linha formatada
				for (Lancamento lancamento : grupoLancamento.getLancamentos()) {
					stringBuilder.append(
							String.format(
									"\t [%s] %s - %s\n",
									new SimpleDateFormat("dd/MM/yyyy").format(lancamento.getData()),
									lancamento.getDescricao(),
									NumberFormat.getCurrencyInstance().format(lancamento.getValor())
							)
					);
				}

				String lancamentoFormatado = stringBuilder.toString();
				return grupoLancamentoFormatado + lancamentoFormatado;
			}

		};
	}

}
