package com.school_control.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Professor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nome_professor", length = 150, nullable = false)
	private String nomeProfessor;
	@ManyToOne
	private Sala salaProfessor;
	
	public Professor() {
		
	}

	public Professor(Integer id, String nomeProfessor, Sala salaProfessor) {
		super();
		this.id = id;
		this.nomeProfessor = nomeProfessor;
		this.salaProfessor = salaProfessor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public Sala getSalaProfessor() {
		return salaProfessor;
	}

	public void setSalaProfessor(Sala salaProfessor) {
		this.salaProfessor = salaProfessor;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", nomeProfessor=" + nomeProfessor + ", salaProfessor=" + salaProfessor + "]";
	}
}
