# primeiroprojetospringbatch
https://www.udemy.com/course/curso-para-desenvolvimento-de-jobs-com-spring-batch/  

## Artigos  

The Domain Language of Batch  
https://docs.spring.io/spring-batch/docs/current/reference/html/domain.html#domainLanguageOfBatch  

Desenvolvimento com Spring Batch — Jobs  
https://giuliana-bezerra.medium.com/desenvolvimento-com-spring-batch-jobs-b4363dd6c676  

Desenvolvimento com Spring Batch — Steps  
https://giuliana-bezerra.medium.com/desenvolvimento-com-spring-batch-steps-4d42af2696ec  


## Job Repository  
É a base de dados onde são armazenados os metadados do spring batch,   
através dele conseguimos várias informações sobre a execução dos jobs.  
BATCH_JOB_INSTANCE - Todas as execuções com sucesso.  
BATCH_JOB_EXECUTION - Todas as execuções independente de sucesso ou não, mostra o status.  
BATCH_JOB_EXECUTION_CONTEXT - Informações adicionais que podem ser passadas no contexto de execução, como informações de negócio por exemplo.  
BATCH_JOB_EXECUTION_PARAMS - Apresenta os parametros de execução do job.  

BATCH_STEP_EXECUTION - Verificar quais steps executaram.  
BATCH_STEP_EXECUTION_CONTEXT - Informações do contexto do step.  

o chunk(10) define que são executados 10 registros por vez, para cada chunk é feita uma transação na base  
de dados, o ideal é pensar sempre na performance da base, pois neste caso os 10 registros ficarão em memória.  
na tabela BATCH_STEP_EXECUTION.COMMIT_COUNT mostra a contagem de quantas transações foram comitadas.  

O restar de jobs com falha só se recupera a partir de chuncks que foram concluídos com sucesso, por esse motivo  
é importante pensar na quantidade de chunks para processamento, e não deixar um valor muito alto, pois caso aconteca  
uma falha no job, somente será retomado até o último concluído.  

## Leitor de Json  
https://docs.spring.io/spring-batch/docs/current/reference/html/index-single.html#JsonItemReader  

## Reforço leitores  
Para reforçar o aprendizado a respeito da leitura em banco de dados com Spring Batch, sugiro o seguinte artigo para leitura:  
https://docs.spring.io/spring-batch/docs/current/reference/html/readersAndWriters.html#database  

Você também pode customizar um leitor. O exemplo abaixo mostra como criar um leitor que acessa um serviço REST para carregar dados:  
https://www.petrikainulainen.net/programming/spring-framework/spring-batch-tutorial-reading-information-from-a-rest-api/  

E se você quiser trabalhar com uma infraestrutura de filas assíncronas, também dá usar um componente específico do Spring Batch:  
https://github.com/spring-tips/kafka-and-spring-batch/blob/master/src/main/java/com/example/bk/consumer/ConsumerApplication.java  

## ItemProcessor  
Como leitura, sugiro o seguinte artigo:  
https://docs.spring.io/spring-batch/docs/current/reference/html/readersAndWriters.html#itemProcessor  

Existem outras implementações de ItemProcessor no Spring Batch que não vimos nessa seção.  
Elas podem ser encontradas na documentação da interface.   
https://docs.spring.io/spring-batch/docs/current/api/org/springframework/batch/item/ItemProcessor.html  
Um excelente exercício para você praticar é criar um job e utilizar alguma dessas implementações (e.g. FunctionItemProcessor).   
https://docs.spring.io/spring-batch/docs/current/api/org/springframework/batch/item/function/FunctionItemProcessor.html  
Pode parecer desafiador, mas esses componentes são bastante simples de utilizar.   
Garanto que você irá tirar de letra e se divertir no processo! 

## Escritores de banco de dados  
Para reforçar o aprendizado a respeito da escrita em banco de dados com Spring Batch, você pode consultar as implementações existentes de escritores de banco do Spring Batch:  
https://docs.spring.io/spring-batch/docs/current/reference/html/readersAndWriters.html#databaseWriters  
E que tal se aventurar implementando uma delas? Você pode modificar um dos projetos que vimos nessa seção para utilizar o HibernateItemWriter, por exemplo. Não tenha medo de tentar, errar faz parte do aprendizado!  
https://docs.spring.io/spring-batch/docs/current/reference/html/readersAndWriters.html#hibernateItemWriter  


