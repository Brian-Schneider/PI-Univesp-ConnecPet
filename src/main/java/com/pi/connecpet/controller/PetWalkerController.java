package com.pi.connecpet.controller;

import com.pi.connecpet.dto.PetSitterDTO;
import com.pi.connecpet.dto.PetWalkerDTO;
import com.pi.connecpet.service.PetWalkerService;
import com.pi.connecpet.service.PrestadorService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetWalkerController {

    @Autowired
    private PetWalkerService petWalkerService;

    @Autowired
    private PrestadorService prestadorService;

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        mav.addObject("message", ex.getMessage());
        return mav;
    }

    @GetMapping("/petwalkers/cadastrar/{prestadorId}")
    public String cadastrarPetWalker(Model model, @PathVariable Long prestadorId) {
        PetWalkerDTO petWalkerDTO = new PetWalkerDTO();
        petWalkerDTO.setPrestadorId(prestadorId);
        model.addAttribute("petWalkerDTO", petWalkerDTO);
        return "petwalkers/cadastrar-petwalker";
    }

    @GetMapping("/petwalkers/alterar/{prestadorId}")
    public String alterarPetWalker(Model model, @PathVariable Long prestadorId) {
        PetWalkerDTO petWalkerDTO = petWalkerService.getPetWalkerByPrestadorId(prestadorId);
        model.addAttribute("petWalkerDTO", petWalkerDTO);
        return "petwalkers/alterar-petwalker";
    }

    @PostMapping("/petwalkers/cadastrar/{prestadorId}")
    public String cadastrarPetWalker(@ModelAttribute PetWalkerDTO petWalkerDTO, @PathVariable Long prestadorId) {
        prestadorService.validatePrestadorId(prestadorId);
        petWalkerService.savePetWalker(petWalkerDTO, prestadorId);

        return "redirect:/prestadores/detalhes/" + prestadorId;
    }
}
