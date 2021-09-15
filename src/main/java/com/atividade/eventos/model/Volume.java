package com.atividade.eventos.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import java.util.Date;
import java.util.Objects;

@Entity
public class Volume implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToMany(mappedBy = "volume")
  @JsonManagedReference
  private List<Artigo> artigos;

  @Column(length = 32)
  private String sigla_evento;
  private Integer num_edicao_evento;

  @Column(length = 64)
  private String cidade_evento;

  @Temporal(value = TemporalType.DATE)
  private Date data_inicio_evento;

  @Column(length = 2048)
  private String descricao_pt;

  @Column(length = 2048)
  private String descricao_en;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<Artigo> getArtigos() {
    return artigos;
  }

  public void setArtigos(List<Artigo> artigos) {
    this.artigos = artigos;
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

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 23 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Volume other = (Volume) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

}
