package com.example.demo.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AlbumDTO;
import com.example.demo.models.Album;
import com.example.demo.repositories.IAlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	IAlbumRepository ar;
	
	public List<AlbumDTO> listarTodos() {
		List<Album> album = ar.findAll();
		List<AlbumDTO> dto = album.stream().map(obj -> new AlbumDTO(obj)).collect(Collectors.toList());
		return dto;
	}
	
	public Album listarUnico(UUID id) {
		return ar.findById(id).get();
	}
	
	public Album salvar(Album novo) {
		return ar.save(novo);
	}
	
	public Album alterar(UUID id, Album alterado) {
		Album albumAntigo = listarUnico(id);
		alterado.setIdAlbum(albumAntigo.getIdAlbum());
		albumAntigo = alterado;
		return salvar(albumAntigo);
	}
	
	public void deletar(UUID id) {
		Album album = listarUnico(id);
		ar.delete(album);
	}

}
