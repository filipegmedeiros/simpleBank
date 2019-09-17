package com.simpleBank.controller;


import com.simpleBank.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class ClienteController {
    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public String index(){return "banco/Cliente"; }

/*    @RequestMapping(value = "/addCliente", method = RequestMethod.POST)
    public String adicionarCliente(
            @ModelAttribute("SpringWeb") Cliente cliente, ModelMap model,
            HttpServletRequest request) {


        model.addAttribute("nome", cliente.getNome());
        model.addAttribute("cpf", cliente.getCpf());


        ArrayList<Cliente> clientes = (ArrayList<Cliente>)
                request.getSession().getAttribute("clientes");
        if (clientes == null) {
            clientes = new ArrayList<Cliente>();
        }
        clientes.add(cliente);
        request.getSession().setAttribute("clientes", clientes);

        return "banco/Cliente";
    }*/

}
