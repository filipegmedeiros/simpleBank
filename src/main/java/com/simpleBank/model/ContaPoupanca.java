package com.simpleBank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numeroDaConta, double saldo, double limite, String senha) {
        super(numeroDaConta, saldo, limite, senha);
    }

}
