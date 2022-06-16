package com.example.demo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Album;
import com.example.demo.services.AlbumService;

@RestController
@RequestMapping("/album")
public class AlbumController {
	
	@Autowired
	AlbumService as;
	
	@GetMapping
	@ResponseBody
	public List<Album> listarAlbuns() {
		return as.listarTodos();
	}
	
	@GetMapping
	@ResponseBody
	public Album listarAlbumId(@PathVariable UUID idAlbum) {
		return as.listarUnico(idAlbum);
	}
	
	@PostMapping
	@ResponseBody
	public Album salvarAlbum(@PathVariable Album novoAlbum) {
		return as.salvar(novoAlbum);
	}
	
	@PutMapping
	@ResponseBody
	public Album alterarAlbum(@PathVariable UUID idAlbum, Album novoAlbum) {
		return as.alterar(idAlbum, novoAlbum);
	}
	
	@DeleteMapping
	@ResponseBody
	public String deletarAlbum(@PathVariable UUID idAlbum) {
		as.deletar(idAlbum);
		return "Album: " + idAlbum + " Deletado!";
	}
	
}
