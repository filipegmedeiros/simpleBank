package com.simpleBank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Conta {

    protected int numeroDaConta;
    protected double saldo;
    protected double limite;
    protected String senha;

    public Conta(String senha){
        this.senha = senha;
    }

}
