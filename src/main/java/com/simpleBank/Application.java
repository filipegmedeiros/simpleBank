package com.simpleBank;

import com.simpleBank.controller.BancoController;
import com.simpleBank.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);

        BancoController bancoJavaOne = new BancoController();

        Cliente cliente01 = new Cliente("Filipe", "CPF", 7000.0);
        Cliente cliente02 = new Cliente("Gustavo", "CPF", 1000.0);


        Conta conta01 = new ContaCorrente(111, 0, cliente01.getRenda(), "segredo");

        ContaPoupanca conta02 = new ContaPoupanca(222, 0, cliente02.getRenda(), "segredo2");


        bancoJavaOne.setContas(conta01, cliente01);
        bancoJavaOne.setContas(conta02, cliente02);


        bancoJavaOne.extrato(111, "segredo");
        bancoJavaOne.extrato(222, "segredo2");


        System.out.println("Depositado 1000 na conta de Filipe");
        System.out.println("-------------------------------------");
        bancoJavaOne.depositar(111, 1000);


        System.out.println("Transferido 999 da conta de Filipe para Gustavo");
        System.out.println("-------------------------------------");
        bancoJavaOne.transferir(111, "segredo", 222, 999);

        bancoJavaOne.extrato(111, "segredo");
        bancoJavaOne.extrato(222, "segredo2");



        Main banco = new Main();

        banco.iniciarBanco();

    }
}

