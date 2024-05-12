package com.pi.connecpet.controller;

import com.pi.connecpet.dto.PetSitterDTO;
import com.pi.connecpet.dto.PrestadorDTO;
import com.pi.connecpet.service.PetSitterService;
import com.pi.connecpet.service.PrestadorService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetSitterController {

    @Autowired
    private PetSitterService petSitterService;

    @Autowired
    private PrestadorService prestadorService;

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        mav.addObject("message", ex.getMessage());
        return mav;
    }

    @GetMapping("/petsitters/cadastrar/{prestadorId}")
    public String cadastrarPetSitter(Model model, @PathVariable Long prestadorId) {
        PetSitterDTO petSitterDTO = new PetSitterDTO();
        petSitterDTO.setPrestadorId(prestadorId);
        model.addAttribute("petSitterDTO", petSitterDTO);
        System.out.println(petSitterDTO);
        return "cadastrar-petsitter";
    }

    @PostMapping("/petsitters/cadastrar/{prestadorId}")
    public String cadastrarPetSitter(@ModelAttribute PetSitterDTO petSitterDTO, @PathVariable(required = false) Long prestadorId) {

        petSitterService.savePetSitter(petSitterDTO, prestadorId);
        return "redirect:/prestadores";
    }


}
