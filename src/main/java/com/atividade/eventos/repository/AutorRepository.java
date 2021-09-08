package com.atividade.eventos.repository;

import java.util.List;

import com.atividade.eventos.model.Autor;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Integer> {
  // @Query(value = "SELECT * FROM autor au WHERE au.artigo_id = :artigo_id",
  // nativeQuery = true)
  // List<Autor> listVolumesArtigosAutores(@Param("artigo_id") Integer artigo_id);
}