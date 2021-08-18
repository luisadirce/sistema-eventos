package com.atividade.eventos.controller;

import com.atividade.eventos.model.Artigo;
import com.atividade.eventos.repository.ArtigoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artigos")
public class ArtigoController {

    @Autowired
    private ArtigoRepository artigoRepository;

    // criacao de artigo
    @PostMapping(value = "/novo")
    public Artigo create(@RequestBody Artigo artigo) {
        return artigoRepository.save(artigo);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity retrieveArtigo(@PathVariable("id") Integer id) {
        return artigoRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    // atualiza um artigo
    @PutMapping(value = "/{id}")
    Artigo update(@RequestBody Artigo novoArtigo, @PathVariable("id") Integer id) {
        return artigoRepository.findById(id).map(artigo -> {
            artigo.setVolume(novoArtigo.getVolume());
            artigo.setAutores(novoArtigo.getAutores());
            artigo.setOrdem_artigo_volume(novoArtigo.getOrdem_artigo_volume());
            artigo.setIdioma(novoArtigo.getIdioma());
            artigo.setTitulo_original(novoArtigo.getTitulo_original());
            artigo.setTitulo_ingles(novoArtigo.getTitulo_ingles());
            artigo.setResumo_original(novoArtigo.getResumo_original());
            artigo.setResumo_en(novoArtigo.getResumo_en());
            artigo.setPalavras_chave_original(novoArtigo.getPalavras_chave_original());
            artigo.setPalavras_chave_en(novoArtigo.getPalavras_chave_en());
            artigo.setPags_artigo(novoArtigo.getPags_artigo());
            return artigoRepository.save(novoArtigo);
        }).orElseGet(() -> {
            novoArtigo.setId(id);
            return artigoRepository.save(novoArtigo);
        });
    }

    // remove um artigo de um volume
    @DeleteMapping("/deletar/{id}")
    public @ResponseBody String delete(@PathVariable("id") Integer id) {
        artigoRepository.deleteById(id);
        return "Artigo deletado";
    }
}