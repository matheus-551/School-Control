package com.school_control.controller;

import java.util.List;

import com.school_control.exception.RegraNegocioException;
import com.school_control.model.Professor;
import com.school_control.model.Sala;
import com.school_control.service.ProfessorService;
import com.school_control.service.SalaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProfessorController {
    
    @Autowired
    private ProfessorService professorService;

    @Autowired
    private SalaService salaService;

    @GetMapping("/home-professor")
    public String ListaProfessor(Model model){
        List<Professor> professores = this.professorService.ListarTodosProfessores();                   

        model.addAttribute("ListaProfessor", professores);
        return"professor/HomeProfessor";
    }

    @GetMapping("cadastrar-professor")
    public String ExibirCadastroProfessor(Model model){
        Professor professor = new Professor();
        List<Sala> salas = this.salaService.ListarTodasSalas();
        
        model.addAttribute("ListaSala", salas);
        model.addAttribute("professorObj", professor);

        return"professor/CadastroProfessor";
    }

    @PostMapping("/salvar-professor")
    public String SalvaProfessor(Professor professor, RedirectAttributes ra, Model model){

        try {
            this.professorService.SalvarProfessor(professor);
            ra.addFlashAttribute("MsgSucess", "Professor Salvo com sucesso !");
            return"redirect:/home-professor";
        }catch (RegraNegocioException e){
            ra.addFlashAttribute("MsgError", e.getMessage());
            return"redirect:/cadastrar-professor";
        }
    }

    @GetMapping("/alterar-professor")
    public String EditaProfessor(Integer id, Model model){
        Professor professor = this.professorService.BuscaPorId(id);
        List<Sala> salas = this.salaService.ListarTodasSalas();
        
        model.addAttribute("ListaSala", salas);
        model.addAttribute("professorObj", professor);
        
        return"professor/CadastroProfessor";
    }
}
