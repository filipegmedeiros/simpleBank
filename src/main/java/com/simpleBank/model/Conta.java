package com.simpleBank.model;

import java.util.Map;

public class Conta {

    Map<Conta,Cliente> clientesCadastrados;

    protected double numeroDaConta;
    protected Cliente cliente;
    protected double saldo;
    protected double limite;
    protected String senha;



    public void depositar(double numeroDaConta, double valor ){
        clientesCadastrados.forEach((Conta,Cliente)->{
                if (numeroDaConta == Conta.numeroDaConta && numeroDaConta < Conta.getLimite()) {
                    setSaldo(getSaldo() + valor);
                }

        });
    }

    public void sacar(double numeroDaConta, String senha, double valorAserSacado ){
        clientesCadastrados.forEach((Conta,Cliente)->{
            if (numeroDaConta == Conta.numeroDaConta && senha.equals(Conta.senha) && valorAserSacado < Conta.getSaldo()) {
                setSaldo(getSaldo() - valorAserSacado);
            }
        });
    }

    public void transferir(double numeroDaContaQueVaiTransferir, double numeroDaContaQueVaiReceber , String senha, double valorAserTransferido ){
        clientesCadastrados.forEach((Conta,Cliente)->{
            if (numeroDaContaQueVaiTransferir == Conta.numeroDaConta && senha.equals(Conta.senha) && valorAserTransferido < Conta.getSaldo()) {
                depositar(numeroDaContaQueVaiReceber,valorAserTransferido);
            }
        });
    }

    public void extrato(double numeroDaConta, String senha){
        clientesCadastrados.forEach((Conta,Cliente)->{
            if (numeroDaConta == Conta.numeroDaConta && senha.equals(Conta.senha)){
                System.out.println("Nome:" + Cliente.getNome());
                System.out.println("Saldo:" + Conta.getSaldo());
                System.out.println("Limite:" + Conta.getLimite());

            }
        });
    }

    public Map<Conta, Cliente> getClientesCadastrados() {
        return clientesCadastrados;
    }

    public void setClientesCadastrados(Map<Conta, Cliente> clientesCadastrados) {
        this.clientesCadastrados = clientesCadastrados;
    }

    public double getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(double numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
