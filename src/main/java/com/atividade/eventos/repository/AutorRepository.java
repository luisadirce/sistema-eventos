package com.atividade.eventos.repository;

import com.atividade.eventos.model.Autor;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}