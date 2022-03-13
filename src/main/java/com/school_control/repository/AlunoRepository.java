package com.school_control.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school_control.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
