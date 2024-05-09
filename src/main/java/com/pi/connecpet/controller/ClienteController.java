package com.pi.connecpet.controller;

import com.pi.connecpet.dto.ClienteDTO;
import com.pi.connecpet.service.ClienteService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        mav.addObject("message", ex.getMessage());
        return mav;
    }

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
        model.addAttribute("clienteDTO", new ClienteDTO());
        return "cadastrar-cliente";
    }

    @GetMapping("/clientes/alterar/{id}")
    public String AlterarCliente(Model model, @PathVariable Long id){
        model.addAttribute("clienteDTO", clienteService.getClienteById(id));
        return "alterar-cliente";
    }

    @PostMapping("/clientes/cadastrar")
    public String CadastrarCliente(@Valid @ModelAttribute ClienteDTO clienteDTO,
                                   BindingResult result) {
        if (result.hasErrors()) {
            return "cadastrar-cliente";
        }
        clienteService.saveCliente(clienteDTO);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/remover/{id}")
    public String RemoverCliente(Model model, @PathVariable Long id){
        model.addAttribute("cliente", clienteService.getClienteById(id));
        return "remover-cliente";
    }

    @PostMapping("/clientes/remover")
    public String RemoverCliente(@ModelAttribute ClienteDTO clienteDTO){
        clienteService.deleteCliente(clienteDTO);
        return "redirect:/clientes";
    }

}
