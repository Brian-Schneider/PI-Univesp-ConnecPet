package com.pi.connecpet.controller;

import com.pi.connecpet.dto.ClienteDTO;
import com.pi.connecpet.dto.PetDTO;
import com.pi.connecpet.service.ClienteService;
import com.pi.connecpet.service.PetService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private ClienteService clienteService;

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        mav.addObject("message", ex.getMessage());
        return mav;
    }

    @GetMapping("/pets")
    public String listarPets(Model model){
        model.addAttribute("listarPets", petService.getAllPets());
        return "pets/lista-pets";
    }

    @GetMapping("/pets/cadastrar")
    public String cadastrarPet(Model model){
        List<ClienteDTO> clientesDTO = clienteService.getAllClientes();


        model.addAttribute("petDTO", new PetDTO());
        model.addAttribute("listarClientes", clientesDTO);
        model.addAttribute("porteValues", petService.getPorteValues());
        model.addAttribute("sexoValues", petService.getSexoValues());
        return "pets/cadastrar-pet";
    }

    @GetMapping("/pets/cadastrar/{clienteId}")
    public String cadastrarPet(Model model, @PathVariable(required = false) Long clienteId){
        if (clienteId == null) {
            model.addAttribute("clienteDTO", clienteService.getClienteById(clienteId));
        }
        model.addAttribute("petDTO", new PetDTO());
        model.addAttribute("listarClientes", clienteService.getAllClientes());
        model.addAttribute("porteValues", petService.getPorteValues());
        model.addAttribute("sexoValues", petService.getSexoValues());
        return "pets/cadastrar-pet";
    }

    @PostMapping("/pets/cadastrar/{clienteId}")
    public String cadastrarPet(@Valid @ModelAttribute PetDTO petDTO,
                               BindingResult result, @PathVariable(required = false) Long clienteId) {

        if (result.hasErrors()) {
            return "pets/cadastrar-pet";
        }
        petService.savePet(petDTO, clienteId);
        return "redirect:/clientes/detalhes/" + clienteId;
    }

    @GetMapping("/pets/alterar/{id}")
    public String alterarPet(Model model, @PathVariable Long id) {
        PetDTO petDTO = petService.getPetById(id);
        List<ClienteDTO> clientesDTO = clienteService.getAllClientes();
        model.addAttribute("petDTO", petDTO);
        model.addAttribute("listarClientes", clientesDTO);
        model.addAttribute("clienteDTO", clienteService.getClienteById(petDTO.getClienteId()));
        model.addAttribute("porteValues", petService.getPorteValues());
        model.addAttribute("sexoValues", petService.getSexoValues());
        return "pets/alterar-pet";
    }

    @PostMapping("/pets/alterar")
    public String alterarPet(@Valid @ModelAttribute PetDTO petDTO,
                             BindingResult result) {

        if (result.hasErrors()) {
            return "pets/alterar-pet";
        }
        petService.updatePet(petDTO);
        return "redirect:/";
    }

    @GetMapping("/pets/remover/{id}")
    public String removerPet(Model model, @PathVariable Long id) {
        PetDTO petDTO = petService.getPetById(id);
        model.addAttribute("pet", petDTO);
        return "pets/remover-pet";
    }

    @PostMapping("/pets/remover")
    public String removerPet(@ModelAttribute PetDTO petDTO) {
        Long clienteId = petDTO.getClienteId();
        petService.deletePet(petDTO);
        return "redirect:/clientes/detalhes/" + clienteId;
    }


}
