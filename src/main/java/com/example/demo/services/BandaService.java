package com.example.demo.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BandaDTO;
import com.example.demo.models.Banda;
import com.example.demo.repositories.IBandaRepository;

@Service
public class BandaService {
	
	@Autowired
	IBandaRepository br;
	
	public List<BandaDTO> listarTodos() {
		List<Banda> banda = br.findAll();
		List<BandaDTO> dto = banda.stream().map(obj -> new BandaDTO(obj)).collect(Collectors.toList());
		return dto;
	}
	
	public Banda listarUnico(UUID id) {
		return br.findById(id).get();
	}
	
	public Banda salvar(Banda nova) {
		return br.save(nova);
	}
	
	public Banda alterar(UUID id, Banda alterada) {
		Banda bandaAntiga = listarUnico(id);
		alterada.setIdBanda(bandaAntiga.getIdBanda());
		bandaAntiga = alterada;
		return salvar(bandaAntiga);
	}
	
	public void deletar(UUID id) {
		 Banda banda = listarUnico(id);
		br.delete(banda);
	}

}
