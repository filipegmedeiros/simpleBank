package com.simpleBank.controller;

import com.simpleBank.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteController {

    @GetMapping("/cadastrarCliente")
    public String sendForm(Cliente cliente) {

        return "cliente/cadastrarCliente";
    }

    @PostMapping("/cadastrarCliente")
    public String processForm(Cliente cliente) {

        return "cliente/informacoesCliente";
    }
}
