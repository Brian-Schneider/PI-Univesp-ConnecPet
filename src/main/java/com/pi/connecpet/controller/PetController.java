package com.pi.connecpet.controller;

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

    @GetMapping("/pets/cadastrar/{clienteId}")
    public String CadastrarPet(Model model, @PathVariable Long clienteId){
        model.addAttribute("clienteDTO", clienteService.getClienteById(clienteId));
        model.addAttribute("petDTO", new PetDTO());
        model.addAttribute("porteValues", petService.getPorteValues());
        model.addAttribute("sexoValues", petService.getSexoValues());
        return "cadastrar-pet";
    }

    @PostMapping("/pets/cadastrar/{clienteId}")
    public String CadastrarPet(@Valid @ModelAttribute PetDTO petDTO,
                               BindingResult result, @PathVariable Long clienteId) {

        if (result.hasErrors()) {
            return "cadastrar-pet";
        }
        petService.savePet(petDTO, clienteId);
        return "redirect:/clientes/detalhes/" + clienteId;
    }

    @GetMapping("/pets/alterar/{id}")
    public String AlterarPet(Model model, @PathVariable Long id) {
        PetDTO petDTO = petService.getPetById(id);
        model.addAttribute("petDTO", petService.getPetById(id));
        model.addAttribute("clienteDTO", clienteService.getClienteById(petDTO.getClienteId()));
        model.addAttribute("porteValues", petService.getPorteValues());
        model.addAttribute("sexoValues", petService.getSexoValues());
        return "alterar-pet";
    }

    @PostMapping("/pets/alterar")
    public String AlterarPet(@Valid @ModelAttribute PetDTO petDTO,
                             BindingResult result) {

        if (result.hasErrors()) {
            return "alterar-pet";
        }
        petService.updatePet(petDTO);
        return "redirect:/";
    }

    @GetMapping("/pets/remover/{id}")
    public String RemoverPet(Model model, @PathVariable Long id) {
        PetDTO petDTO = petService.getPetById(id);
        model.addAttribute("pet", petDTO);
        return "remover-pet";
    }

    @PostMapping("/pets/remover")
    public String RemoverPet(@ModelAttribute PetDTO petDTO) {
        Long clienteId = petDTO.getClienteId();
        petService.deletePet(petDTO);
        return "redirect:/clientes/detalhes/" + clienteId;
    }


}
