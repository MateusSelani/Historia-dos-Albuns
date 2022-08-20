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

import com.example.demo.dto.AlbumDTO;
import com.example.demo.models.Album;
import com.example.demo.services.AlbumService;

@RestController
@RequestMapping("/album")
public class AlbumController {
	
	@Autowired
	AlbumService as;
	
	@ResponseBody
	@GetMapping
	public List<AlbumDTO> listarAlbuns() {
		return as.listarTodos();
	}
	
	@ResponseBody
	@GetMapping("/{idAlbum}")
	public AlbumDTO listarAlbumId(@PathVariable UUID idAlbum) {
		return as.listarUnico(idAlbum);
	}
	
	@ResponseBody
	@PostMapping
	public AlbumDTO salvarAlbum(@RequestBody Album novoAlbum) {
		return as.salvar(novoAlbum);
	}
	
	@ResponseBody
	@PutMapping("/{idAlbum}")
	public AlbumDTO alterarAlbum(@PathVariable UUID idAlbum ,@RequestBody Album novoAlbum) {
		return as.alterar(idAlbum, novoAlbum);
	}
	
	@ResponseBody
	@DeleteMapping("/{idAlbum}")
	public String deletarAlbum(@PathVariable UUID idAlbum) {
		as.deletar(idAlbum);
		return "Album: " + idAlbum + " Deletado!";
	}
	
}
