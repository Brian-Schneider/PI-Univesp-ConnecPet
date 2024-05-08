package com.pi.connecpet.controller;

import com.pi.connecpet.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public String ListarClientes(Model model){
        model.addAttribute("listarClientes", clienteService.getAllClientes());
        return "listaClientes";
    }

}