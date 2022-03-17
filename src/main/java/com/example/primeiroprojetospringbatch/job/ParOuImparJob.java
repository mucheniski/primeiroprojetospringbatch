//package com.example.primeiroprojetospringbatch.batch;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.function.FunctionItemProcessor;
//import org.springframework.batch.item.support.IteratorItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Configuration
//@EnableBatchProcessing
//public class BatchParOuImpar {
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Job imprimeParOuImparJob() {
//        return jobBuilderFactory
//                .get("imprimeParOuImparJob")
//                .start(imprimeParouImparSetp())
//                .incrementer(new RunIdIncrementer())
//                .build();
//    }
//
//    public Step imprimeParouImparSetp() {
//        return stepBuilderFactory
//                .get("imprimeParouImparSetp")
//                .<Integer, String>chunk(10) // <Integer, String> Vai ler Integer e escrever String
//                .reader(contaAteDezReader())
//                .processor(parOuImparProcessor())
//                .writer(imprimeWriter())
//                .build();
//    }
//
//    /*
//    * O Leitor recebe uma coleção
//    * */
//    public IteratorItemReader<Integer> contaAteDezReader() {
//        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//        return new IteratorItemReader<Integer>(numeros.iterator());
//    }
//
//    /*
//    * O Processador recebe um item da coleção de cada vez e processa o item
//    * */
//    public FunctionItemProcessor<Integer, String> parOuImparProcessor() {
//
//        FunctionItemProcessor itemProcessor = new FunctionItemProcessor<Integer, String>(
//                numero -> numero % 2 == 0 ? String.format("Numero %s é par", numero) : String.format("Numero %s é impar", numero)
//        );
//
//        return itemProcessor;
//    }
//
//    /*
//    * O Escritor recebe a coleção processada pronta.
//    * */
//    public ItemWriter<String> imprimeWriter() {
//        return numerosProcessados -> numerosProcessados.forEach(System.out::println);
//    }
//
//}
