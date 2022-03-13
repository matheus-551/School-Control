package com.school_control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school_control.exception.RegraNegocioException;
import com.school_control.model.Professor;
import com.school_control.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public List<Professor> ListarTodosProfessores(){
		return this.professorRepository.findAll();
	}
	
	public void SalvarProfessor(Professor professor) {
		
		if(professor.getNomeProfessor() == null || professor.getNomeProfessor().trim().equals("")) {
			throw new RegraNegocioException("Digite um nome válido");
		}
		
		this.professorRepository.save(professor);
	}
	
	public Professor BuscaPorId(Integer id) {
		return this.professorRepository.getById(id);
	}
}
