package com.atividade.eventos.controller;

import javax.validation.Valid;

import com.atividade.eventos.model.Autor;
import com.atividade.eventos.repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    // formulário de criação de autor novo
    @GetMapping("/createauthor")
    public String showCreateAuthorForm(Autor autor) {
        return "new-author";
    }

    // criação de autor novo
    @PostMapping("/newauthor")
    public String newAuthor(@Valid Autor autor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new-author";
        }

        autorRepository.save(autor);
        return "redirect:/";
    }

    // recupera author específico
    @GetMapping(value = "author/{id}")
    public String retrieveAuthor(@PathVariable("id") int id, Model model) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de autor inválido:" + id));

        model.addAttribute("autor", autor);
        return "author-details";
    }

    // atualiza author
    @GetMapping("author/edit/{id}")
    public String showUpdateAuthorForm(@PathVariable("id") int id, Model model) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de volume inválido:" + id));

        model.addAttribute("autor", autor);
        return "update-author";
    }

    @PostMapping("author/update/{id}")
    public String updateAuthor(@PathVariable("id") int id, @Valid Autor autor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            autor.setId(id);
            return "update-author";
        }

        autorRepository.save(autor);
        return "redirect:/author/{id}";
    }

    @GetMapping("author/delete/{id}")
    public String deleteAuthor(@PathVariable("id") int id, Model model) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de volume inválido:" + id));
        autorRepository.delete(autor);
        return "redirect:/";
    }
}
