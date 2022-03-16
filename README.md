# primeiroprojetospringbatch
https://www.udemy.com/course/curso-para-desenvolvimento-de-jobs-com-spring-batch/  

## Job Repository  
É a base de dados onde são armazenados os metadados do spring batch,   
através dele conseguimos várias informações sobre a execução dos jobs.  
BATCH_JOB_INSTANCE - Todas as execuções com sucesso.  
BATCH_JOB_EXECUTION - Todas as execuções independente de sucesso ou não, mostra o status.  
BATCH_JOB_EXECUTION_CONTEXT - Informações adicionais que podem ser passadas no contexto de execução, como informações de negócio por exemplo.  
BATCH_JOB_EXECUTION_PARAMS - Apresenta os parametros de execução do job.  

BATCH_STEP_EXECUTION - Verificar quais steps executaram.  
BATCH_STEP_EXECUTION_CONTEXT - Informações do contexto do step.  


