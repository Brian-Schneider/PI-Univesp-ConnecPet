package com.pi.connecpet.controller;

import com.pi.connecpet.dto.PrestadorDTO;
import com.pi.connecpet.service.PrestadorService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrestadorController {

    @Autowired
    private PrestadorService prestadorService;

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        mav.addObject("message", ex.getMessage());
        return mav;
    }

    @GetMapping("/prestadores")
    public String listarPrestadores(@RequestParam(required = false) String tipo, Model model) {
        model.addAttribute("listarPrestadores", prestadorService.getAllPrestadores(tipo));
        model.addAttribute("tipo", tipo);
        return "lista-prestadores";
    }

    @GetMapping("/prestadores/detalhes/{id}")
    public String detalhesPrestador(Model model, @PathVariable Long id) {
        model.addAttribute("detalhesPrestador", prestadorService.getPrestadorWithSitterAndOrWalkerById(id));
        return "detalhes-prestador";
    }

    @GetMapping("/prestadores/cadastrar")
    public String cadastrarPrestador(Model model) {
        model.addAttribute("prestadorDTO", new PrestadorDTO());
        return "cadastrar-prestador";
    }

    @PostMapping("/prestadores/cadastrar")
    public String cadastrarPrestador(PrestadorDTO prestadorDTO, Model model) {
        PrestadorDTO prestadorCadastrado = prestadorService.savePrestador(prestadorDTO, prestadorDTO.getIsPetSitter(), prestadorDTO.getIsPetWalker());
        model.addAttribute("prestadorCadastrado", prestadorCadastrado);

        if (prestadorDTO.getIsPetSitter()) {
            return "redirect:/petsitters/cadastrar/" + prestadorCadastrado.getId();
        } else if (prestadorDTO.getIsPetWalker()) {
            return "redirect:/petwalker/cadastrar";
        } else {
            return "lista-prestadores"; // return to the prestador details view
        }
    }

}
