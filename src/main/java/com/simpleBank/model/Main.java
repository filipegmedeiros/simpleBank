package com.simpleBank.model;

import com.simpleBank.controller.BancoController;
import lombok.Setter;

import java.util.Random;
import java.util.Scanner;

@Setter
public class Main {
    BancoController bancoJavaOne;
    Scanner cin;
    Random rnd;
    private boolean loop;

    public Main() {
        bancoJavaOne = new BancoController();
        rnd = new Random();
        cin = new Scanner(System.in);
        this.loop = true;
    }


    public Cliente cadastroCliente() {
        String nome;
        String cpf;
        Double renda;

        System.out.println("<============ Cadastro Cliente ============>");

        System.out.println("Digite Seu Nome: ");
        nome = cin.nextLine();
        System.out.println("Digite Seu Cpf: ");
        cpf = cin.next();
        System.out.println("Digite Sua Renda: ");
        renda = cin.nextDouble();

        Cliente cliente = new Cliente(nome, cpf, renda);
        return cliente;
    }


    public Conta cadastroConta(Cliente cliente) {

        System.out.println("<============ Cadastro Conta ============>");
        System.out.println("01) Criar uma Conta Corrente");
        System.out.println("02) Criar uma Conta Poupanca");
        System.out.println("03) Voltar ao Menu");
        System.out.println("Para Sair do Sistema, basta escolher uma opcao invalida.");

        Conta conta;
        String senha;

        System.out.println("Digite Sua Senha: ");
        senha = cin.next();
        conta = new ContaPoupanca((100000 + rnd.nextInt(900000)), 0, cliente.getRenda(), senha);
        return conta;
    }

    public void criarConta() {

        /*@Todo:
            Existe no ArrayList Cliente com esse Nome e CPF?
            IF(true):
              cadastroConta(cliente)
              bancoJavaOne.setContas(cadastroConta(cliente),cliente);
            ELSE
                cadastrarCliente()
                bancoJavaOne.setContas(cadastroConta(cliente),cliente);
         */

        Cliente cliente = cadastroCliente();
        Conta conta = cadastroConta(cliente);
        bancoJavaOne.setContas(conta, cliente);

        System.out.println("Digite Sua Senha: ");
        String senha = cin.next();
        bancoJavaOne.extrato(conta.getNumeroDaConta(), senha);
        bancoJavaOne.depositar(conta.getNumeroDaConta(), 1000);


    }

    public void acessarConta() {
        /*@Todo:
            Existe no Map a Conta?
            IF(true):
              menu de deposito/ saque/ transferencia
            ELSE IF
                desejar criar uma conta?
            ELSE
                sair do programa
         */
        System.out.println("01) Digite o numero da Conta: ");
        int numeroDaConta = cin.nextInt();
        System.out.println("Digite sua Senha: ");
        String senha = cin.next();

        double valor;


        if (bancoJavaOne.existeConta(numeroDaConta, senha)) {
            System.out.println("Digite valor para ser sacado: ");
            valor = cin.nextDouble();
            bancoJavaOne.sacar(numeroDaConta, senha, valor);
            bancoJavaOne.extrato(numeroDaConta, senha);
        } else {
            System.out.println("Digite valor para deposito: ");
            valor = cin.nextDouble();
            bancoJavaOne.depositar(numeroDaConta, valor);
            bancoJavaOne.extrato(numeroDaConta, senha);
        }


    }


    public void iniciarBanco() {

        System.out.println("<============ MENU ============>");
        System.out.println("01) Cadastrar Cliente");
        System.out.println("02) Criar uma Conta");
        System.out.println("03) Acessar Conta");
        System.out.println("04) Voltar ao Menu");
        System.out.println("Para Sair do Sistema, basta escolher uma opcao invalida.");

        while (loop) {
            int escolha;
            Scanner cin = new Scanner(System.in);
            escolha = cin.nextInt();
            switch (escolha) {

                case 1:
                    criarConta();
                    break;

                case 2:
                    acessarConta();
                    break;

                case 3:
                    iniciarBanco();

                default:
                    setLoop(false);


            }


        }
    }

}
