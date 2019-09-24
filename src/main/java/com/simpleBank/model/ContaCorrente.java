package com.simpleBank.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;


@Getter
@Setter
@NoArgsConstructor
public class ContaCorrente extends Conta {

    public ContaCorrente(int numeroDaConta, double saldo, double limite, String senha) {
        super(numeroDaConta, saldo, limite * 0.3, senha);
    }

}
