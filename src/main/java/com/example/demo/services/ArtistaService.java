package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Artista;
import com.example.demo.repositories.IArtistaRepository;

@Service
public class ArtistaService {
	
	@Autowired
	IArtistaRepository artr;
	
	public List<Artista> listarTodos(){
		return artr.findAll();
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
