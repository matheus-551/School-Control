package com.school_control.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school_control.model.Sala;

public interface SalaRepository extends JpaRepository<Sala, Integer>{
	
	boolean existsByNomeSala(String nomeSala);
}
