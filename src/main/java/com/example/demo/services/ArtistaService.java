package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ArtistaDTO;
import com.example.demo.models.Artista;
import com.example.demo.repositories.IArtistaRepository;

@Service
public class ArtistaService {
	
	@Autowired
	IArtistaRepository artr;
	
	public List<ArtistaDTO> listarTodos(){
		List<Artista> artistas = artr.findAll();
		return ArtistaDTO.conversorArtistaDto(artistas);
	}
	
	public ArtistaDTO listarPorId(UUID id){
		Artista artista = artr.findById(id).get();
		return ArtistaDTO.conversorArtistaDto(artista);
	}
	
	public ArtistaDTO salvar(Artista artista){
		artr.save(artista);
		return ArtistaDTO.conversorArtistaDto(artista);
	}
	
	public ArtistaDTO alterar(UUID id, Artista novoArtista){
		Artista artista = artr.findById(id).get();
		novoArtista.setIdArtista(artista.getIdArtista());
		artista = novoArtista;
		salvar(artista);
		return ArtistaDTO.conversorArtistaDto(artista);
	}
	
	public String deletar(UUID id){
		artr.delete(artr.findById(id).get());
		return "Artista: "+ id +" Deletado!";
	}

	
}
