package com.pi.connecpet.controller;

import com.pi.connecpet.dto.PetWalkerDTO;
import com.pi.connecpet.service.PetWalkerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetWalkerController {

    @Autowired
    private PetWalkerService petWalkerService;

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        mav.addObject("message", ex.getMessage());
        return mav;
    }

    @GetMapping("/petwalker/cadastrar")
    public String cadastrarPetWalker(Model model) {
        model.addAttribute("petWalkerDTO", new PetWalkerDTO());
        return "cadastrar-petwalker";
    }

    @PostMapping("/petwalker/cadastrar")
    public String cadastrarPetWalker(PetWalkerDTO petWalkerDTO) {
        petWalkerService.savePetWalker(petWalkerDTO);
        return "redirect:/prestadores";
    }
}
