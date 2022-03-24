package com.example.primeiroprojetospringbatch.processors.contasbancarias.domain;

import com.example.primeiroprojetospringbatch.processors.contasbancarias.domain.enums.TipoContaEnum;
import lombok.Data;

@Data
public class Conta {

    private Integer id;
    private TipoContaEnum tipo;
    private Double limite;
    private String cliente_id;

}
