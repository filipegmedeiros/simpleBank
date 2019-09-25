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
        bancoJavaOne.setCliente(cliente);
        return cliente;
    }

    public Conta cadastroConta(Cliente cliente) {

        System.out.println("<============ Cadastro Conta ============>");
        System.out.println("01) Criar uma Conta Corrente");
        System.out.println("02) Criar uma Conta Poupanca");
        System.out.println("03) Voltar ao Menu");
        System.out.println("Para Sair do Sistema, basta escolher uma opcao invalida.");

        String senha;
        Scanner cin = new Scanner(System.in);
        int escolha = cin.nextInt();
        switch (escolha) {

            case 1:
                System.out.println("Digite Sua Senha: ");
                senha = cin.next();
                ContaCorrente contaCorrente = new ContaCorrente((100000 + rnd.nextInt(900000)), 0, cliente.getRenda(), senha);
                return contaCorrente;

            case 2:
                System.out.println("Digite Sua Senha: ");
                senha = cin.next();
                ContaPoupanca contaPoupanca = new ContaPoupanca((100000 + rnd.nextInt(900000)), 0, cliente.getRenda(), senha);
                return contaPoupanca;

            case 3:
                iniciarBanco();

            default:
                setLoop(false);

        }
        return null;
    }

    public void criarConta() {
        Cliente a = new Cliente("f","2",100.0);

        System.out.println("Digite Seu Nome: ");
        String nome = cin.nextLine();
        System.out.println("Digite Seu Cpf: ");
        String cpf = cin.next();
        if (bancoJavaOne.existeCliente(nome, cpf) == true)
            cadastroConta(bancoJavaOne.buscarCliente(nome, cpf));
        else {
            Cliente novoCliente = cadastroCliente();
            bancoJavaOne.setContas(cadastroConta(novoCliente), novoCliente);
        }

    }

    public void acessarConta() {

        System.out.println("01) Digite o numero da Conta: ");
        int numeroDaConta = cin.nextInt();
        System.out.println("Digite sua Senha: ");
        String senha = cin.next();

        if (bancoJavaOne.existeConta(numeroDaConta, senha)) {
            System.out.println("Digite valor para ser sacado: ");
            double valor = cin.nextDouble();
            bancoJavaOne.sacar(numeroDaConta, senha, valor);
            bancoJavaOne.extrato(numeroDaConta, senha);
        } else {
            System.out.println("Conta Inexistente, deseja criar?");
            iniciarBanco();
        }

    }

    public void iniciarBanco() {

        System.out.println("<============ MENU ============>");
        System.out.println("01) Criar uma Conta");
        System.out.println("02) Acessar Conta");
        System.out.println("03) Voltar ao Menu");
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
