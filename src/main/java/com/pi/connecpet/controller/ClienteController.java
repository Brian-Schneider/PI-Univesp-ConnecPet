package com.pi.connecpet.controller;

import com.pi.connecpet.dto.ClienteDTO;
import com.pi.connecpet.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public String ListarClientes(Model model){
        model.addAttribute("listarClientes", clienteService.getAllClientes());
        return "lista-clientes";
    }

    @GetMapping("/clientes/detalhes/{id}")
    public String DetalhesCliente(Model model, @PathVariable Long id){
        model.addAttribute("detalhesCliente", clienteService.getClienteById(id));
        return "detalhes-cliente";
    }

    @GetMapping("/clientes/cadastrar")
    public String CadastrarCliente(Model model){
        model.addAttribute("cliente", new ClienteDTO());
        return "cadastrar-cliente";
    }

    @PostMapping("/clientes/cadastrar")
    public String SalvarCliente(@ModelAttribute ClienteDTO clienteDTO){
        clienteService.saveCliente(clienteDTO);
        return "redirect:/clientes";
    }

}
