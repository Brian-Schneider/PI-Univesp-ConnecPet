package com.pi.connecpet.controller;

import ch.qos.logback.core.net.server.Client;
import com.pi.connecpet.dto.AgendamentoDTO;
import com.pi.connecpet.dto.ClienteDTO;
import com.pi.connecpet.dto.PetDTO;
import com.pi.connecpet.dto.PrestadorDTO;
import com.pi.connecpet.service.AgendamentoService;
import com.pi.connecpet.service.ClienteService;
import com.pi.connecpet.service.PrestadorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private PrestadorService prestadorService;

    private static final Logger logger = LoggerFactory.getLogger(AgendamentoController.class);


    @Autowired
    private ClienteService clienteService;

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        mav.addObject("message", ex.getMessage());
        return mav;
    }

    @GetMapping("/agendamentos")
    public String listarAgendamentos(Model model){
        model.addAttribute("listarAgendamentos", agendamentoService.getAllAgendamentos());
        return "agendamentos/lista-agendamentos";
    }

    @GetMapping("/agendamentos/cadastrar")
    public String cadastrarAgendamento(Model model){
        model.addAttribute("agendamentoDTO", new AgendamentoDTO());
        return "agendamentos/cadastrar-agendamento";
    }

    @PostMapping("/agendamentos/cadastrar")
    public String cadastrarAgendamento(@Valid @ModelAttribute AgendamentoDTO agendamentoDTO,
                                       BindingResult result) {

        if (result.hasErrors()) {
            return "agendamentos/cadastrar-agendamento";
        }
        agendamentoService.saveAgendamento(agendamentoDTO);
        return "redirect:/agendamentos";
    }

    @GetMapping("/agendamentos/alterar/{id}")
    public String alterarAgendamento(Model model, @PathVariable Long id) {
        AgendamentoDTO agendamentoDTO = agendamentoService.getAgendamento(id);
        System.out.println(agendamentoDTO.toString());
        model.addAttribute("agendamentoDTO", agendamentoDTO);
        return "agendamentos/alterar-agendamento";
    }

    @PostMapping("/agendamentos/alterar")
    public String alterarAgendamento(@Valid @ModelAttribute AgendamentoDTO agendamentoDTO,
                                     BindingResult result) {

        if (result.hasErrors()) {
            return "agendamentos/alterar-agendamento";
        }
        agendamentoService.updateAgendamento(agendamentoDTO.getId(), agendamentoDTO);
        return "redirect:/agendamentos";
    }

    @GetMapping("/agendamentos/remover/{id}")
    public String removerAgendamento(Model model, @PathVariable Long id) {
        AgendamentoDTO agendamentoDTO = agendamentoService.getAgendamento(id);
        model.addAttribute("agendamento", agendamentoDTO);
        return "agendamentos/remover-agendamento";
    }

    @PostMapping("/agendamentos/remover")
    public String removerAgendamento(@ModelAttribute AgendamentoDTO agendamentoDTO) {
        agendamentoService.cancelAgendamento(agendamentoDTO.getId());
        return "redirect:/agendamentos";
    }

    @GetMapping("/agendamentos/clientes")
    @ResponseBody
    public List<ClienteDTO> listarClientes() {
        List<ClienteDTO> clientes = clienteService.getAllClientes();
        return clientes;
    }

    @GetMapping("/agendamentos/pets/{clientId}")
    @ResponseBody
    public List<PetDTO> getPetsByClientId(@PathVariable Long clientId) {
        ClienteDTO cliente = clienteService.getClienteById(clientId);
        System.out.println(cliente.getPets().toString());
        return cliente.getPets();
    }

    @GetMapping("/agendamentos/prestadores/{serviceType}")
    @ResponseBody
    public List<PrestadorDTO> getPrestadoresByServiceType(@PathVariable String serviceType) {
        List<PrestadorDTO> prestadores = agendamentoService.getPrestadoresByServiceType(serviceType);
        return prestadores;
    }

    @GetMapping("/agendamentos/prestador/{id}")
    @ResponseBody
    public PrestadorDTO getPrestadorById(@PathVariable Long id) {
        logger.info("Entering getPrestadorById");
        PrestadorDTO prestador = prestadorService.getPrestadorById(id);
        logger.info("Exiting getPrestadorById");
        return prestador;
    }

    @GetMapping("/agendamentos/buscar/{id}")
    @ResponseBody
    public AgendamentoDTO getAgendamentoById(@PathVariable Long id) {
        AgendamentoDTO agendamento = agendamentoService.getAgendamento(id);
        return agendamento;
    }
}