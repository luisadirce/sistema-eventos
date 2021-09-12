package com.atividade.eventos.controller;

import javax.validation.Valid;

import com.atividade.eventos.model.Artigo;
import com.atividade.eventos.repository.ArtigoRepository;
import com.atividade.eventos.repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArtigoController {

    @Autowired
    private ArtigoRepository artigoRepository;

    @Autowired
    private AutorRepository autorRepository;

    // formulário de criação de artigo
    @GetMapping("/createarticle")
    public String showCreateArticleForm(Artigo artigo) {
        return "new-article";
    }

    // criação de artigo
    @PostMapping("/newarticle")
    public String newArticle(@Valid Artigo artigo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new-article";
        }

        artigoRepository.save(artigo);
        return "redirect:/";
    }

    // recupera artigo específico
    @GetMapping(value = "article/{id}")
    public String retrieveVolume(@PathVariable("id") int id, Model model) {
        Artigo artigo = artigoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de artigo inválido:" + id));
        model.addAttribute("artigo", artigo);

        model.addAttribute("autores", autorRepository.findAll());

        return "article-details";
    }

    // formulário de edição de artigo
    @GetMapping("article/edit/{id}")
    public String showUpdateArticleForm(@PathVariable("id") int id, Model model) {
        Artigo artigo = artigoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de artigo inválido:" + id));

        model.addAttribute("artigo", artigo);

        model.addAttribute("autores", autorRepository.findAll());

        return "update-artigo";
    }

    // atualiza artigo
    @PostMapping("article/update/{id}")
    public String updateArticle(@PathVariable("id") int id, @Valid Artigo artigo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            artigo.setId(id);
            return "update-article";
        }

        artigoRepository.save(artigo);
        return "redirect:/article/{id}";
    }

    // deleta artigo
    @GetMapping("article/delete/{id}")
    public String deleteArticle(@PathVariable("id") int id, Model model) {
        Artigo artigo = artigoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de artigo inválido:" + id));
        artigoRepository.delete(artigo);

        return "redirect:/";
    }

}