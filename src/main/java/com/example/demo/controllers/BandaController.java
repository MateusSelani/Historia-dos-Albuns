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

import com.example.demo.models.Banda;
import com.example.demo.services.BandaService;

@RestController
@RequestMapping("/banda")
public class BandaController {
	
	@Autowired
	BandaService bs;
	
	@ResponseBody
	@GetMapping
	public List<Banda> listarBandas() {
		return bs.listarTodos();
	}
	
	@ResponseBody
	@GetMapping("/{idBanda}")
	public Banda listarBandaId(@PathVariable UUID idBanda) {
		return bs.listarUnico(idBanda);
	}
	
	@ResponseBody
	@PostMapping
	public Banda salvarBanda(@RequestBody Banda novaBanda) {
		return bs.salvar(novaBanda);
	}
	
	@ResponseBody
	@PutMapping("/{idBanda}")
	public Banda alterarBanda(@PathVariable UUID idBanda, @RequestBody Banda novaBanda) {
		return bs.alterar(idBanda, novaBanda);
	}
	
	@ResponseBody
	@DeleteMapping("/{idBanda}")
	public String deletarBanda(@PathVariable UUID idBanda) {
		bs.deletar(idBanda);
		return "Banda: " + idBanda + " Deletada!";
	}

}
