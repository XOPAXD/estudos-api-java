package com.jhone.estudos.repositories;

import com.jhone.estudos.dominio.Quadrinhos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuadrinhosRepository extends JpaRepository<Quadrinhos, Integer> {
}
