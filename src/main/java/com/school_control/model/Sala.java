package com.school_control.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sala {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nome_sala", length = 150, nullable = false)
	private String nomeSala;
	
	public Sala() {
		
	}

	public Sala(Integer id, String nomeSala) {
		super();
		this.id = id;
		this.nomeSala = nomeSala;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeSala() {
		return nomeSala;
	}

	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", nomeSala=" + nomeSala + "]";
	}
}
