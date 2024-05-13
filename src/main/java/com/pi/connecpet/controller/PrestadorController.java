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
        return "prestadores/lista-prestadores";
    }

    @GetMapping("/prestadores/detalhes/{id}")
    public String detalhesPrestador(Model model, @PathVariable Long id) {
        model.addAttribute("detalhesPrestador", prestadorService.getPrestadorWithSitterAndOrWalkerById(id));
        return "prestadores/detalhes-prestador";
    }

    @GetMapping("/prestadores/cadastrar")
    public String cadastrarPrestador(Model model) {
        model.addAttribute("prestadorDTO", new PrestadorDTO());
        return "prestadores/cadastrar-prestador";
    }

    @PostMapping("/prestadores/cadastrar")
    public String cadastrarPrestador(PrestadorDTO prestadorDTO, Model model) {
        PrestadorDTO prestadorCadastrado = prestadorService.savePrestador(prestadorDTO, prestadorDTO.getIsPetSitter(), prestadorDTO.getIsPetWalker());
        model.addAttribute("prestadorCadastrado", prestadorCadastrado);

        if (prestadorDTO.getIsPetSitter()) {
            return "redirect:/petsitters/cadastrar/" + prestadorCadastrado.getId();
        } else if (prestadorDTO.getIsPetWalker()) {
            return "redirect:/petwalkers/cadastrar/" + prestadorCadastrado.getId();
        } else {
            return "prestadores/lista-prestadores";
        }
    }

    @GetMapping("/prestadores/alterar/{id}")
    public String alterarPrestador(Model model, @PathVariable Long id) {
        model.addAttribute("prestadorDTO", prestadorService.getPrestadorById(id));
        return "prestadores/alterar-prestador";
    }

    @PostMapping("/prestadores/alterar")
    public String alterarPrestador(@ModelAttribute PrestadorDTO prestadorDTO, Model model) {
        model.addAttribute("prestadorDTO", prestadorDTO);
        prestadorService.savePrestador(prestadorDTO, prestadorDTO.getIsPetSitter(), prestadorDTO.getIsPetWalker());

        if (prestadorDTO.getIsPetSitter()) {
            return "redirect:/petsitters/alterar/" + prestadorDTO.getId();
        } else if (prestadorDTO.getIsPetWalker()) {
            return "redirect:/petwalkers/alterar/" + prestadorDTO.getId();
        } else {
            return "redirect:/prestadores/detalhes/" + prestadorDTO.getId();
        }
    }

    @GetMapping("/prestadores/remover/{id}")
    public String removerPrestador(Model model, @PathVariable Long id) {
        model.addAttribute("prestador", prestadorService.getPrestadorById(id));
        return "prestadores/remover-prestador";
    }

    @PostMapping("/prestadores/remover")
    public String removerPrestador(@ModelAttribute PrestadorDTO prestadorDTO) {
        prestadorService.deletePrestador(prestadorDTO);
        return "redirect:/prestadores";
    }

}
