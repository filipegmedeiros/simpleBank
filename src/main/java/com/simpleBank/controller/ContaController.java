package com.simpleBank.controller;

import com.simpleBank.model.Conta;
import com.simpleBank.model.ContaCorrente;
import com.simpleBank.model.ContaPoupanca;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class ContaController {

    @RequestMapping("/conta")
    public String index(){return "banco/Conta"; }

/*    @RequestMapping(value = "/addContaCorrente", method = RequestMethod.POST)
    public String adicionarContaCorrente(
            @ModelAttribute("SpringWeb") ContaCorrente contaCorrente, ModelMap model,
            HttpServletRequest request) {


        model.addAttribute("saldo", contaCorrente.getSaldo());
        model.addAttribute("limite", contaCorrente.getLimite());
        model.addAttribute("cliente", contaCorrente.getCliente());
        model.addAttribute("agencia", contaCorrente.getAgencia());


        ArrayList<ContaCorrente> contasCorrentes = (ArrayList<ContaCorrente>)
                request.getSession().getAttribute("contasCorrentes");
        if (contasCorrentes == null) {
            contasCorrentes = new ArrayList<ContaCorrente>();
        }
        contasCorrentes.add(contaCorrente);
        request.getSession().setAttribute("contaCorrente", contaCorrente);

        return "exibeContaCorrente";
    }

    @RequestMapping(value = "/addContaPoupanca", method = RequestMethod.POST)
    public String adicionarContaPoupanca(
            @ModelAttribute("SpringWeb") ContaPoupanca contaPoupanca, ModelMap model,
            HttpServletRequest request) {


        model.addAttribute("saldo", contaPoupanca.getSaldo());
        model.addAttribute("limite", contaPoupanca.getLimite());
        model.addAttribute("cliente", contaPoupanca.getCliente());
        model.addAttribute("agencia", contaPoupanca.getAgencia());


        ArrayList<ContaPoupanca> contasPoupancas = (ArrayList<ContaPoupanca>)
                request.getSession().getAttribute("contasCorrentes");
        if (contasPoupancas == null) {
            contasPoupancas = new ArrayList<ContaPoupanca>();
        }
        contasPoupancas.add(contaPoupanca);
        request.getSession().setAttribute("contaCorrente", contaPoupanca);

        return "banco/Conta";
    }*/

}
