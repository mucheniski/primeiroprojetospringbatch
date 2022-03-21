package com.example.primeiroprojetospringbatch.arquivomultiplosformatos.reader;

import com.example.primeiroprojetospringbatch.domain.Cliente;
import com.example.primeiroprojetospringbatch.domain.Transacao;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;


public class ArquivoClienteTransacaoReader implements ItemStreamReader<Cliente> {

    private Object objetoAtual;
    private ItemStreamReader<Object> leitorObjetoDelegate;

    public ArquivoClienteTransacaoReader(ItemStreamReader<Object> leitorObjetoDelegate) {
        this.leitorObjetoDelegate = leitorObjetoDelegate;
    }

    @Override
    public Cliente read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        if (objetoAtual == null) {
            objetoAtual = leitorObjetoDelegate.read();
        }

        Cliente cliente = (Cliente) objetoAtual;
        objetoAtual = null;

        if (cliente != null) {
            while (verProximoItem() instanceof Transacao) {
                cliente.addTrancacao((Transacao) objetoAtual);
            }
        }
        return cliente;

    }

    private Object verProximoItem() throws Exception {
        objetoAtual = leitorObjetoDelegate.read();
        return objetoAtual;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        leitorObjetoDelegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        leitorObjetoDelegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        leitorObjetoDelegate.close();
    }
}
