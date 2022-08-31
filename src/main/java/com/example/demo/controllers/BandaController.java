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

import com.example.demo.dto.BandaDTO;
import com.example.demo.models.Banda;
import com.example.demo.services.BandaService;

@RestController
@RequestMapping("/banda")
public class BandaController {
	
	@Autowired
	BandaService bs;
	
	@ResponseBody
	@GetMapping
	public ResponseEntity<List<BandaDTO>> listarBandas() {
		List<BandaDTO> dto = bs.listarTodos();
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@ResponseBody
	@GetMapping("/{idBanda}")
	public ResponseEntity<BandaDTO> listarBandaId(@PathVariable UUID idBanda) {
		BandaDTO dto = bs.listarUnico(idBanda);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@ResponseBody
	@PostMapping
	public ResponseEntity<BandaDTO> salvarBanda(@RequestBody Banda novaBanda) {
		BandaDTO dto = bs.salvar(novaBanda);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	
	@ResponseBody
	@PutMapping("/{idBanda}")
	public ResponseEntity<BandaDTO> alterarBanda(@PathVariable UUID idBanda, @RequestBody Banda novaBanda) {
		BandaDTO dto = bs.alterar(idBanda, novaBanda);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@ResponseBody
	@DeleteMapping("/{idBanda}")
	public ResponseEntity<String> deletarBanda(@PathVariable UUID idBanda) {
		String dto = bs.deletar(idBanda);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}

}