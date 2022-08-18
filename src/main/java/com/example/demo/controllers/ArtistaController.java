package com.example.demo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ArtistaDTO;
import com.example.demo.models.Artista;
import com.example.demo.services.ArtistaService;

@RestController
@RequestMapping("/artista")
public class ArtistaController {
	
	@Autowired
	ArtistaService arts;
	
	@ResponseBody
	@GetMapping
	public List<ArtistaDTO> listarArtistas(){
		return arts.listarTodos();
	}
	
	@ResponseBody
	@GetMapping("/{idArtista}")
	public ArtistaDTO listarArtista(@PathVariable UUID idArtista) {
		return arts.listarPorId(idArtista);
	}
	
	@ResponseBody
	@PostMapping
	public ArtistaDTO salvarArtista(@RequestBody Artista artista) {
		return arts.salvar(artista);
	}
	
	@ResponseBody
	@PutMapping("/{idArtista}")
	public ArtistaDTO alterarArtista(@PathVariable UUID idArtista, @RequestBody Artista artista) {
		return arts.alterar(idArtista, artista);
	}
	
	@ResponseBody
	@DeleteMapping("/{idArtista}")
	public String deletarArtista(@PathVariable UUID idArtista) {
		return arts.deletar(idArtista);
	}

}
