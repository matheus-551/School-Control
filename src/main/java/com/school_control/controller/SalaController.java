package com.school_control.controller;

import java.util.List;

import com.school_control.exception.RegraNegocioException;
import com.school_control.model.Sala;
import com.school_control.service.SalaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SalaController {
    
    @Autowired
    private SalaService salaService;

    @GetMapping("/home-sala")
    public String ListaSala(Model model){
        List<Sala> salas = this.salaService.ListarTodasSalas();
        model.addAttribute("ListaSala", salas);    
        return"sala/HomeSala";
    }

    @GetMapping("/cadastrar-sala")
    public String ExibirCadastroSala(Model model){
        Sala sala = new Sala();
        model.addAttribute("salaObj", sala);
        return"sala/CadastroSala";
    }

    @PostMapping("/salvar-sala")
    public String SalvaSala(Sala sala, RedirectAttributes ra, Model model){
        
        try {
            this.salaService.SalvarSala(sala);
            ra.addFlashAttribute("MsgSucess", "Sala salva com sucesso !");
            return"redirect:/home-sala";
        }catch (RegraNegocioException e){
            ra.addFlashAttribute("MsgError", e.getMessage());
            return"redirect:/cadastrar-sala";
        }
    }

    @GetMapping("/alterar-sala")
    public String EditaSala(Integer id, Model model){
        Sala sala = this.salaService.BuscaPorId(id);
        model.addAttribute("salaObj", sala);
        return"sala/CadastroSala";
    }
}
