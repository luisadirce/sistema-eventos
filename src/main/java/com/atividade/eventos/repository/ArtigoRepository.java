package com.atividade.eventos.repository;

import java.util.List;

import com.atividade.eventos.model.Artigo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtigoRepository extends CrudRepository<Artigo, Integer> {
  @Query(value = "SELECT * FROM artigo a WHERE a.volume_id = :volume_id", nativeQuery = true)
  List<Artigo> listVolumesArtigos(@Param("volume_id") Integer volume_id);
}
