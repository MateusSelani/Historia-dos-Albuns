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
	public ResponseEntity<List<ArtistaDTO>> listarArtistas(){
		List<ArtistaDTO> dto = arts.listarTodos();
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@ResponseBody
	@GetMapping("/{idArtista}")
	public ResponseEntity<ArtistaDTO> listarArtista(@PathVariable UUID idArtista) {
		ArtistaDTO dto = arts.listarPorId(idArtista);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@ResponseBody
	@PostMapping
	public ResponseEntity<ArtistaDTO> salvarArtista(@RequestBody Artista artista) {
		ArtistaDTO dto = arts.salvar(artista);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@ResponseBody
	@PutMapping("/{idArtista}")
	public ResponseEntity<ArtistaDTO> alterarArtista(@PathVariable UUID idArtista, @RequestBody Artista artista) {
		ArtistaDTO dto = arts.alterar(idArtista, artista);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@ResponseBody
	@DeleteMapping("/{idArtista}")
	public ResponseEntity<String> deletarArtista(@PathVariable UUID idArtista) {
		String dto = arts.deletar(idArtista);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}

}
