package com.school_control.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Aluno {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nome_aluno", length = 150, nullable = false)
	private String nomeAluno;
	@ManyToOne
	private Professor professorAluno;
	
	public Aluno() {
		
	}

	public Aluno(Integer id, String nomeAluno, Professor professorAluno) {
		super();
		this.id = id;
		this.nomeAluno = nomeAluno;
		this.professorAluno = professorAluno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Professor getProfessorAluno() {
		return professorAluno;
	}

	public void setProfessorAluno(Professor professorAluno) {
		this.professorAluno = professorAluno;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nomeAluno=" + nomeAluno + ", professorAluno=" + professorAluno + "]";
	}
}
