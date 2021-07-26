package com.atividade.eventos.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Date;

@Entity
public class Volume implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @OneToMany(mappedBy = "volume")
  private List<Artigo> artigos;

  private String sigla_evento;
  private Integer num_edicao_evento;
  private String cidade_evento;
  
  @Temporal(value=TemporalType.TIMESTAMP)
  private Date data_inicio_evento;
  private String descricao_pt;
  private String descricao_en;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSigla_evento() {
    return sigla_evento;
  }

  public void setSigla_evento(String sigla_evento) {
    this.sigla_evento = sigla_evento;
  }

  public Integer getNum_edicao_evento() {
    return num_edicao_evento;
  }

  public void setNum_edicao_evento(Integer num_edicao_evento) {
    this.num_edicao_evento = num_edicao_evento;
  }

  public String getCidade_evento() {
    return cidade_evento;
  }

  public void setCidade_evento(String cidade_evento) {
    this.cidade_evento = cidade_evento;
  }

  public Date getData_inicio_evento() {
    return data_inicio_evento;
  }

  public void setData_inicio_evento(Date data_inicio_evento) {
    this.data_inicio_evento = data_inicio_evento;
  }

  public String getDescricao_pt() {
    return descricao_pt;
  }

  public void setDescricao_pt(String descricao_pt) {
    this.descricao_pt = descricao_pt;
  }

  public String getDescricao_en() {
    return descricao_en;
  }

  public void setDescricao_en(String descricao_en) {
    this.descricao_en = descricao_en;
  }
}
