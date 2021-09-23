package com.jhone.estudos.repositories;

import com.jhone.estudos.dominio.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
