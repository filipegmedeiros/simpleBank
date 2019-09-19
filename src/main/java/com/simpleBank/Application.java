package com.simpleBank;

import com.simpleBank.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);

        Cliente cliente01 = new Cliente("Filipe","CPF",700.0);
        Cliente cliente02 = new Cliente("Gustavo","CPF",700.0);

        Conta conta01 = new Conta();
        conta01.setLimite(10000.0);
        conta01.setNumeroDaConta(111);
        conta01.setSenha("segredo");


        Conta conta02 = new Conta();
        conta02.setNumeroDaConta(222);
        conta02.setLimite(10000.0);
        conta02.setSenha("segredo2");


        Map<Conta,Cliente> map = new HashMap<Conta,Cliente>();

        map.put(conta01,cliente01);
        map.put(conta02,cliente02);

        conta01.setClientesCadastrados(map);

        conta01.depositar(111,1000.0);


        System.out.println(conta02.getSaldo());

    }
}

