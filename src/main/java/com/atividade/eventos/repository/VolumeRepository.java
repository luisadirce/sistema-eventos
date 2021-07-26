package com.atividade.eventos.repository;

import com.atividade.eventos.model.Volume;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VolumeRepository extends JpaRepository<Volume, Long> {

}