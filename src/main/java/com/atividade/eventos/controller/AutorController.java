package com.atividade.eventos.controller;

import com.atividade.eventos.model.Autor;
import com.atividade.eventos.repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    // criacao de autor
    @PostMapping(value = "/novo")
    public Autor create(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    // recupera autor específico
    @GetMapping(value = "/{id}")
    public ResponseEntity retrieveVolume(@PathVariable("id") Integer id) {
        return autorRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    // atualiza um autor
    @PutMapping(value = "/{id}")
    Autor update(@RequestBody Autor novoAutor, @PathVariable("id") Integer id) {
        return autorRepository.findById(id).map(autor -> {
            autor.setArtigo(novoAutor.getArtigo());
            autor.setOrdem_autor_artigo(novoAutor.getOrdem_autor_artigo());
            autor.setEmail(novoAutor.getEmail());
            autor.setPrimeiro_nome(novoAutor.getPrimeiro_nome());
            autor.setNome_meio(novoAutor.getNome_meio());
            autor.setSobrenome(novoAutor.getSobrenome());
            autor.setAfiliacao(novoAutor.getAfiliacao());
            autor.setPais(novoAutor.getPais());
            autor.setOrcID(novoAutor.getOrcID());
            return autorRepository.save(novoAutor);
        }).orElseGet(() -> {
            novoAutor.setId(id);
            return autorRepository.save(novoAutor);
        });
    }

    // remove um autor
    @DeleteMapping("/deletar/{id}")
    public @ResponseBody String delete(@PathVariable("id") Integer id) {
        autorRepository.deleteById(id);
        return "Autor deletado";
    }
}
