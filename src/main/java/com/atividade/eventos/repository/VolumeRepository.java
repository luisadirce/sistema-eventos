package com.atividade.eventos.repository;

import com.atividade.eventos.model.Volume;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface VolumeRepository extends CrudRepository<Volume, Integer> {

}