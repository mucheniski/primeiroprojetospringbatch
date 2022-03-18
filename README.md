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

