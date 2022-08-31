package com.example.demo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<List<AlbumDTO>> listarAlbuns() {
		List<AlbumDTO> dto = as.listarTodos();
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@ResponseBody
	@GetMapping("/{idAlbum}")
	public ResponseEntity<AlbumDTO> listarAlbumId(@PathVariable UUID idAlbum) {
		AlbumDTO dto = as.listarUnico(idAlbum);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@ResponseBody
	@PostMapping
	public ResponseEntity<AlbumDTO> salvarAlbum(@RequestBody Album novoAlbum) {
		AlbumDTO dto = as.salvar(novoAlbum); 
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@ResponseBody
	@PutMapping("/{idAlbum}")
	public ResponseEntity<AlbumDTO> alterarAlbum(@PathVariable UUID idAlbum, @RequestBody Album novoAlbum) {
		AlbumDTO dto = as.alterar(idAlbum, novoAlbum);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@ResponseBody
	@DeleteMapping("/{idAlbum}")
	public ResponseEntity<String> deletarAlbum(@PathVariable UUID idAlbum) {
		as.deletar(idAlbum);
		return ResponseEntity.status(HttpStatus.OK).body("Album: " + idAlbum + " Deletado!");
	}
	
}
