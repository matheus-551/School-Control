package com.school_control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school_control.exception.RegraNegocioException;
import com.school_control.model.Aluno;
import com.school_control.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Aluno> ListarTodosAlunos() {
		return this.alunoRepository.findAll();
	}
	
	public void SalvarAluno(Aluno aluno) {
		
		if(aluno.getNomeAluno() == null || aluno.getNomeAluno().trim().equals("")) {
			throw new RegraNegocioException("Digite um nome válido");
		}
		
		this.alunoRepository.save(aluno);
	}
	
	public Aluno BuscaPorId(Integer id) {
		return this.alunoRepository.getById(id);
	}
}
