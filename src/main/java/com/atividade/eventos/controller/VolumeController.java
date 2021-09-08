package com.atividade.eventos.controller;

import java.util.List;

import javax.validation.Valid;

import com.atividade.eventos.model.Artigo;
import com.atividade.eventos.model.Autor;
import com.atividade.eventos.model.Volume;
import com.atividade.eventos.repository.ArtigoRepository;
import com.atividade.eventos.repository.AutorRepository;
import com.atividade.eventos.repository.VolumeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class VolumeController {

    @Autowired
    private VolumeRepository volumeRepository;

    // criacao de volume
    // @PostMapping(value = "/novo")
    // public Volume create(@RequestBody Volume volume) {
    // return volumeRepository.save(volume);
    // }

    // // recupera volume específico
    // @GetMapping(value = "/{id}")
    // public ResponseEntity retrieveVolume(@PathVariable("id") Integer id) {
    // return volumeRepository.findById(id).map(record ->
    // ResponseEntity.ok().body(record))
    // .orElse(ResponseEntity.notFound().build());
    // }

    // // atualiza um volume
    // @PutMapping(value = "/{id}")
    // Volume update(@RequestBody Volume novoVolume, @PathVariable("id") Integer id)
    // {
    // return volumeRepository.findById(id).map(volume -> {
    // volume.setArtigos(novoVolume.getArtigos());
    // volume.setSigla_evento(novoVolume.getSigla_evento());
    // volume.setNum_edicao_evento(novoVolume.getNum_edicao_evento());
    // volume.setCidade_evento(novoVolume.getCidade_evento());
    // volume.setData_inicio_evento(novoVolume.getData_inicio_evento());
    // volume.setDescricao_pt(novoVolume.getDescricao_pt());
    // volume.setDescricao_en(novoVolume.getDescricao_en());
    // return volumeRepository.save(novoVolume);
    // }).orElseGet(() -> {
    // novoVolume.setId(id);
    // return volumeRepository.save(novoVolume);
    // });
    // }

    // // deleta um volume
    // @DeleteMapping(value = "/deletar/{id}")
    // public @ResponseBody String deleteVolume(@PathVariable("id") Integer id) {
    // volumeRepository.deleteById(id);
    // return "Volume deletado";
    // }

    // lista dados de todos os volumes
    // @GetMapping(value = "/lista")
    // public List<Volume> listAllVolumes() {
    // return volumeRepository.findAll();
    // }

    // @Autowired
    // private ArtigoRepository artigoRepository;

    // // lista artigos de um volume
    // @GetMapping("/{idVolume}/artigos")
    // public List<Artigo> listArtigos(@PathVariable("idVolume") Integer idVolume) {
    // return artigoRepository.listVolumesArtigos(idVolume);
    // }

    // @Autowired
    // private AutorRepository autorRepository;

    // // lista dados de todos os autores de artigos de um dado volume
    // @GetMapping("/{idVolume}/artigos/{idArtigo}/autores")
    // public List<Autor> listAutores(@PathVariable("idVolume") Integer idVolume,
    // @PathVariable("idArtigo") Integer idArtigo) {
    // return autorRepository.listVolumesArtigosAutores(idArtigo);
    // }

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
        return "volume-details";
    }

    // atualiza volume
    @GetMapping("volume/edit/{id}")
    public String showUpdateVolumeForm(@PathVariable("id") int id, Model model) {
        Volume volume = volumeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de volume inválido:" + id));

        model.addAttribute("volume", volume);
        return "update-volume";
    }

    @PostMapping("volume/update/{id}")
    public String updateVolume(@PathVariable("id") int id, @Valid Volume volume, BindingResult result, Model model) {
        if (result.hasErrors()) {
            volume.setId(id);
            return "update-volume";
        }

        volumeRepository.save(volume);
        return "redirect:/";
    }

    @GetMapping("volume/delete/{id}")
    public String deleteVolume(@PathVariable("id") int id, Model model) {
        Volume volume = volumeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de volume inválido:" + id));
        volumeRepository.delete(volume);
        return "redirect:/";
    }

}
