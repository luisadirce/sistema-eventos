package com.atividade.eventos.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Autor implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @ManyToOne
  private Artigo artigo;

  private Integer ordem_autor_artigo;
  private Integer email;
  private String primeiro_nome;
  private String nome_meio;
  private String sobrenome;
  private String afiliacao;
  private String pais;
  private String OrcID;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public Artigo getArtigo() {
        return artigo;
    }

    
    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

    
    public Integer getOrdem_autor_artigo() {
        return ordem_autor_artigo;
    }

    
    public void setOrdem_autor_artigo(Integer ordem_autor_artigo) {
        this.ordem_autor_artigo = ordem_autor_artigo;
    }

    
    public Integer getEmail() {
        return email;
    }

    
    public void setEmail(Integer email) {
        this.email = email;
    }

    
    public String getPrimeiro_nome() {
        return primeiro_nome;
    }

    
    public void setPrimeiro_nome(String primeiro_nome) {
        this.primeiro_nome = primeiro_nome;
    }

    
    public String getNome_meio() {
        return nome_meio;
    }

    
    public void setNome_meio(String nome_meio) {
        this.nome_meio = nome_meio;
    }

    
    public String getSobrenome() {
        return sobrenome;
    }

    
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    
    public String getAfiliacao() {
        return afiliacao;
    }

    
    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }

    
    public String getPais() {
        return pais;
    }

    
    public void setPais(String pais) {
        this.pais = pais;
    }

    
    public String getOrcID() {
        return OrcID;
    }

    
    public void setOrcID(String OrcID) {
        this.OrcID = OrcID;
    }

}
