package com.atividade.eventos.repository;

import com.atividade.eventos.model.Volume;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolumeRepository extends CrudRepository<Volume, Integer> {

}