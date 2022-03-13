package com.school_control.controller;

import java.util.List;

import com.school_control.exception.RegraNegocioException;
import com.school_control.model.Aluno;
import com.school_control.model.Professor;
import com.school_control.service.AlunoService;
import com.school_control.service.ProfessorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AlunoController {
    
    @Autowired
    private AlunoService alunoService;

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/home-aluno")
    public String ListaAlunos(Model model){
        Aluno aluno = new Aluno();
        List<Aluno> alunos = this.alunoService.ListarTodosAlunos();
        
        model.addAttribute("ListaAluno", alunos);
        model.addAttribute("alunoObj", aluno);
        
        return"aluno/HomeAluno";
    }

    @GetMapping("/cadastrar-aluno")
    public String ExibirCadastroAluno(Model model){
        Aluno aluno = new Aluno();
        List<Professor> professores = this.professorService.ListarTodosProfessores();
       
        model.addAttribute("ListaProfessor", professores);
        model.addAttribute("alunoObj", aluno);

        return"aluno/CadastroAluno";
    }

    @PostMapping("/salvar-aluno")
    public String SalvaAluno(Aluno aluno, RedirectAttributes ra, Model model){

        try{
            this.alunoService.SalvarAluno(aluno);
            ra.addFlashAttribute("MsgSucess", "Aluno salvo com sucesso !!");
            return"redirect:/home-aluno";
        }catch (RegraNegocioException e){
            ra.addFlashAttribute("MsgError", e.getMessage());
            return"redirect:/cadastrar-aluno";
        }
    }

    @GetMapping("/alterar-aluno")
    public String EditaAluno(Integer id, Model model){
        Aluno aluno = this.alunoService.BuscaPorId(id);
        List<Professor> professores = this.professorService.ListarTodosProfessores();
        
        model.addAttribute("ListaProfessor", professores);
        model.addAttribute("alunoObj", aluno);
        
        return"aluno/CadastroAluno";
    }
}
