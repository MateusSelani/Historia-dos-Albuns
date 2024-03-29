package com.example.demo.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.dto.BandaDTO.*;
import com.example.demo.dto.BandaDTO;
import com.example.demo.models.Banda;
import com.example.demo.repositories.IBandaRepository;

@Service
public class BandaService {
	
	@Autowired
	IBandaRepository br;
	
	public List<BandaDTO> listarTodos() {
		List<Banda> bandas = br.findAll();
		return conversorBandaDto(bandas);
	}
	
	public BandaDTO listarUnico(UUID id) {
		Banda banda = buscarBandaId(id);
		return conversorBandaDto(banda);
	}
	
	public BandaDTO salvar(Banda banda) {
		banda.setDataCadastro(new Date());
		Banda nova = br.save(banda);
		return conversorBandaDto(nova);
	}
	
	public BandaDTO alterar(UUID id, Banda alterada) {
		Banda bandaAntiga = buscarBandaId(id);
		alterada.setIdBanda(bandaAntiga.getIdBanda());
		bandaAntiga = alterada;
		salvar(bandaAntiga);
		return conversorBandaDto(bandaAntiga);
	}
	
	public String deletar(UUID id) {
		Banda banda = buscarBandaId(id);
		br.delete(banda);
		return "Banda: " + banda.getNomeBanda() + " Deletada!";
	}
	
//	metodo interno
	private Banda buscarBandaId(UUID uuid) {
		return br.findById(uuid).get();
	}

}
