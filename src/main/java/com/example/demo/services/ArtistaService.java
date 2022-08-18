package com.example.demo.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
		List<Artista> artista = artr.findAll();
		List<ArtistaDTO> dto = artista.stream().map(obj -> new ArtistaDTO(obj)).collect(Collectors.toList());
		return dto;
	}
	
	public Artista listarPorId(UUID id){
		return artr.findById(id).get();
	}
	
	public Artista salvar(Artista artista){
		return artr.save(artista);
	}
	
	public Artista alterar(UUID id, Artista novoArtista){
		Artista artista = listarPorId(id);
		novoArtista.setIdArtista(artista.getIdArtista());
		artista = novoArtista;
		return salvar(artista);
	}
	
	public String deletar(UUID id){
		artr.delete(listarPorId(id));
		return "Artista: "+ id +" Deletado!";
	}

	
}
