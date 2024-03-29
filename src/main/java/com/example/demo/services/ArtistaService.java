package com.example.demo.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.dto.ArtistaDTO.*;
import com.example.demo.dto.ArtistaDTO;
import com.example.demo.models.Artista;
import com.example.demo.repositories.IArtistaRepository;

@Service
public class ArtistaService {
	
	@Autowired
	IArtistaRepository artr;
	
	public List<ArtistaDTO> listarTodos(){
		List<Artista> artistas = artr.findAll();
		return conversorArtistaDto(artistas);
	}
	
	public ArtistaDTO listarPorId(UUID id){
		Artista artista = buscarArtistaId(id);
		return conversorArtistaDto(artista);
	}
	
	public ArtistaDTO salvar(Artista artista){
		artista.setDataCadastro(new Date());
		artr.save(artista);
		return conversorArtistaDto(artista);
	}
	
	public ArtistaDTO alterar(UUID id, Artista novoArtista){
		Artista artista = buscarArtistaId(id);
		novoArtista.setIdArtista(artista.getIdArtista());
		artista = novoArtista;
		salvar(artista);
		return conversorArtistaDto(artista);
	}
	
	public String deletar(UUID id){
		Artista artista = buscarArtistaId(id);
		artr.delete(artista);
		return "Artista: "+ artista.getNomeArtista() +" Deletado!";
	}
	
//	metodo interno
	private Artista buscarArtistaId(UUID uuid) {
		return artr.findById(uuid).get();
	}

	
}
