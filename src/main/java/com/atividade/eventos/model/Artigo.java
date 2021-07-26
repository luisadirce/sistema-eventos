package com.atividade.eventos.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
public class Artigo implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @ManyToOne
  private Volume volume;

  @OneToMany(mappedBy = "artigo")
  private List<Autor> autores;

  private Integer ordem_artigo_volume;
  private String idioma;
  private String titulo_original;
  private String titulo_ingles;
  private String resumo_original;
  private String resumo_en;
  private String palavras_chave_original;
  private String palavras_chave_en;
  private Integer pags_artigo;

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getOrdem_artigo_volume() {
    return ordem_artigo_volume;
  }
  
  public void setOrdem_artigo_volume(Integer ordem_artigo_volume) {
    this.ordem_artigo_volume = ordem_artigo_volume;
  }

    public Volume getVolume() {
        return volume;
    }

    
    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    
    public List<Autor> getAutores() {
        return autores;
    }

    
    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    
    public String getIdioma() {
        return idioma;
    }

    
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    
    public String getTitulo_original() {
        return titulo_original;
    }

    
    public void setTitulo_original(String titulo_original) {
        this.titulo_original = titulo_original;
    }

    
    public String getTitulo_ingles() {
        return titulo_ingles;
    }

    
    public void setTitulo_ingles(String titulo_ingles) {
        this.titulo_ingles = titulo_ingles;
    }

    
    public String getResumo_original() {
        return resumo_original;
    }

    
    public void setResumo_original(String resumo_original) {
        this.resumo_original = resumo_original;
    }

    
    public String getResumo_en() {
        return resumo_en;
    }

   
    public void setResumo_en(String resumo_en) {
        this.resumo_en = resumo_en;
    }

    
    public String getPalavras_chave_original() {
        return palavras_chave_original;
    }

    
    public void setPalavras_chave_original(String palavras_chave_original) {
        this.palavras_chave_original = palavras_chave_original;
    }

    
    public String getPalavras_chave_en() {
        return palavras_chave_en;
    }

    
    public void setPalavras_chave_en(String palavras_chave_en) {
        this.palavras_chave_en = palavras_chave_en;
    }

    
    public Integer getPags_artigo() {
        return pags_artigo;
    }
    

    public void setPags_artigo(Integer pags_artigo) {
        this.pags_artigo = pags_artigo;
    }
}