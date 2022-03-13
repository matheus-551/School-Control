package com.school_control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school_control.exception.RegraNegocioException;
import com.school_control.model.Sala;
import com.school_control.repository.SalaRepository;

@Service
public class SalaService {
	
	@Autowired	
	private SalaRepository salaRepository;
	
	public List<Sala> ListarTodasSalas(){
		List<Sala> salas = this.salaRepository.findAll();
		return salas;
	}
	
	public void SalvarSala(Sala sala) {
		
		boolean VerificaSala = this.salaRepository.existsByNomeSala(sala.getNomeSala());
		
		if(VerificaSala == true) {
			throw new RegraNegocioException("Já existe uma sala cadastrada com este nome");
		}
		
		if(sala.getNomeSala() == null || sala.getNomeSala().trim().equals("")) {
			throw new RegraNegocioException("Digite um nome válido");
		}
		
		this.salaRepository.save(sala);
	}
	
	public Sala BuscaPorId(Integer id) {
		return this.salaRepository.getById(id);
	}
}
