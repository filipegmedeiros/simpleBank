package com.simpleBank.controller;

import com.simpleBank.model.Cliente;
import com.simpleBank.model.Conta;
import lombok.EqualsAndHashCode;


import java.util.ArrayList;
import java.util.HashMap;

@EqualsAndHashCode
public class BancoController {
    protected ArrayList<Cliente> clientes;

    protected HashMap<Conta, Cliente> contas;

    public BancoController() {
        this.contas = new HashMap<Conta, Cliente>();

    }

    public void setCliente(Cliente cliente){
        clientes.add(cliente);

    }


    public boolean existeConta(int numeroDaConta, String senha){
        return false;
    }

    public void setContas(Conta conta, Cliente cliente) {

        contas.put(conta, cliente);
    }

    public void depositar(int numeroDaConta, double valor) {
        contas.forEach((conta, cliente) -> {
            if (conta.getNumeroDaConta() == numeroDaConta
                    && valor <= conta.getLimite())
                conta.setSaldo(conta.getSaldo() + valor);
        });
    }

    public void sacar(int numeroDaConta, String senha, double valor) {
        contas.forEach((conta, cliente) -> {
            if (conta.getNumeroDaConta() == numeroDaConta
                    && senha.equals(conta.getSenha())
                    && conta.getSaldo() >= (valor)) {

                conta.setSaldo(conta.getSaldo() - valor);
            }
        });
    }

    public void transferir(int numeroDaConta, String senha, int contaQueVaiReceber, int valor) {
        contas.forEach((conta, cliente) -> {
            if (conta.getNumeroDaConta() == numeroDaConta && senha.equals(conta.getSenha())) {
                this.depositar(contaQueVaiReceber, valor);
                this.sacar(numeroDaConta, senha, valor);
            }

        });
    }

    public void extrato(double numeroDaConta, String senha) {
        contas.forEach((conta, cliente) -> {
            if (numeroDaConta == conta.getNumeroDaConta() && senha.equals(conta.getSenha())) {
                System.out.println("<======== Extrado de " + cliente.getNome() + " ========>");
                System.out.println("Numero da Conta:" + conta.getNumeroDaConta());
                System.out.println("Saldo:" + conta.getSaldo());
                System.out.println("Limite Atual:" + conta.getLimite());
                System.out.println("-------------------------------------");

            }
        });
    }

}
