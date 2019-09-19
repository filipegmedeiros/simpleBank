package com.simpleBank.controller;

import com.simpleBank.model.ContaPoupanca;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContaController {

    @RequestMapping("/conta")
    public String conta(){
        return "banco/escolherTipoDeConta";
    }


    @GetMapping("/cadastrarContaPoupanca")
    public String sendForm(ContaPoupanca contaPoupanca) {

        return "banco/cadastrarContaPoupanca";
    }


    @PostMapping("/cadastrarContaPoupanca")
    public String processForm(ContaPoupanca contaPoupanca) {

        return "banco/extrato";
    }

}

