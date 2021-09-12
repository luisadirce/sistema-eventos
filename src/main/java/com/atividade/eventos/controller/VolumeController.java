package com.atividade.eventos.controller;

import java.util.List;

import javax.validation.Valid;

import com.atividade.eventos.model.Artigo;
import com.atividade.eventos.model.Volume;
import com.atividade.eventos.repository.ArtigoRepository;
import com.atividade.eventos.repository.VolumeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VolumeController {

    @Autowired
    private VolumeRepository volumeRepository;

    @Autowired
    private ArtigoRepository artigoRepository;

    // lista artigos de um volume
    @GetMapping("/{idVolume}/artigos")
    public List<Artigo> listArtigos(@PathVariable("idVolume") int idVolume) {
        return artigoRepository.listVolumesArtigos(idVolume);
    }

    // formulário de criação de volume novo
    @GetMapping("/createvolume")
    public String showCreateVolumeForm(Volume volume) {
        return "new-volume";
    }

    // criação de volume novo
    @PostMapping("/newvolume")
    public String newVolume(@Valid Volume volume, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new-volume";
        }

        volumeRepository.save(volume);
        return "redirect:/";
    }

    // lista dados de todos os volumes - nova forma de fazer
    @GetMapping(value = "/")
    public String showVolumeList(Model model) {
        model.addAttribute("volumes", volumeRepository.findAll());
        return "index";
    }

    // recupera volume específico
    @GetMapping(value = "volume/{id}")
    public String retrieveVolume(@PathVariable("id") int id, Model model) {
        Volume volume = volumeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de volume inválido:" + id));

        model.addAttribute("volume", volume);

        model.addAttribute("artigos", artigoRepository.findAll());

        return "volume-details";
    }

    // atualiza volume
    @GetMapping("volume/edit/{id}")
    public String showUpdateVolumeForm(@PathVariable("id") int id, Model model) {
        Volume volume = volumeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de volume inválido:" + id));

        model.addAttribute("volume", volume);

        model.addAttribute("artigos", artigoRepository.findAll());

        return "update-volume";
    }

    @PostMapping("volume/update/{id}")
    public String updateVolume(@PathVariable("id") int id, @Valid Volume volume, BindingResult result, Model model) {
        if (result.hasErrors()) {
            volume.setId(id);
            return "update-volume";
        }

        volumeRepository.save(volume);
        return "redirect:/volume/{id}";
    }

    @GetMapping("volume/delete/{id}")
    public String deleteVolume(@PathVariable("id") int id, Model model) {
        Volume volume = volumeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de volume inválido:" + id));
        volumeRepository.delete(volume);
        return "redirect:/";
    }

}
