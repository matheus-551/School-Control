package com.school_control.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school_control.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

}
