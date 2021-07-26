package com.atividade.eventos.repository;

import com.atividade.eventos.model.Artigo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long> {

}
