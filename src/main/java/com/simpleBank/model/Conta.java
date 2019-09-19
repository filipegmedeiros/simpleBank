package com.simpleBank.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class Conta {

    protected Map<Conta,Cliente> clientesCadastrados = new HashMap<Conta,Cliente>();;

    protected int numeroDaConta;
    protected Cliente cliente;
    protected double saldo;
    protected double limite;
    protected String senha;

    public void setLimite(double limite) {
        this.limite = limite*0.3;
    }


    public void depositar(int numeroDaConta, double valor ){
        clientesCadastrados.forEach((Conta,Cliente)->{
                if (numeroDaConta == Conta.getNumeroDaConta() && valor < Conta.getLimite()) {
                    Conta.setSaldo(Conta.getSaldo() + valor);

                }

        });
    }

    public void sacar(double numeroDaConta, String senha, double valorAserSacado ){
        clientesCadastrados.forEach((Conta,Cliente)->{
            if (numeroDaConta == Conta.numeroDaConta && senha.equals(Conta.senha) && valorAserSacado < Conta.getSaldo()) {
                Conta.setSaldo(Conta.getSaldo() - valorAserSacado);
            }
        });
    }

    public void transferir(double numeroDaContaQueVaiTransferir, String senha, int numeroDaContaQueVaiReceber , double valorQueVaiSerTransferido ){
        clientesCadastrados.forEach((Conta,Cliente)->{
            if (numeroDaContaQueVaiTransferir == Conta.numeroDaConta && senha.equals(Conta.senha) && valorQueVaiSerTransferido < Conta.getSaldo()) {
                depositar(numeroDaContaQueVaiReceber,valorQueVaiSerTransferido);
                sacar(numeroDaContaQueVaiTransferir, senha, valorQueVaiSerTransferido);
            }
        });
    }

    public void extrato(double numeroDaConta, String senha){
        clientesCadastrados.forEach((Conta,Cliente)->{
            if (numeroDaConta == Conta.numeroDaConta && senha.equals(Conta.senha)){
                System.out.println("<=============EXTRATO===============>");
                System.out.println("Nome:" + Cliente.getNome());
                System.out.println("Saldo:" + Conta.getSaldo());
                System.out.println("Limite:" + Conta.getLimite());
                System.out.println("<===============FIM=================>");

            }
        });
    }


}
