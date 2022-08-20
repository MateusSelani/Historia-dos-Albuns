package com.example.demo.services;

import java.util.List;
import java.util.UUID;

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
		List<Album> albuns = ar.findAll();
		List<AlbumDTO> dto = AlbumDTO.conversorAlbumDto(albuns);
		return dto;
	}
	
	public AlbumDTO listarUnico(UUID id) {
		Album album = ar.findById(id).get();
		return AlbumDTO.conversorAlbumDto(album);
	}
	
	public AlbumDTO salvar(Album novo) {
		Album album = ar.save(novo);
		return AlbumDTO.conversorAlbumDto(album);
	}
	
	public AlbumDTO alterar(UUID id, Album alterado) {
		Album albumAntigo = ar.findById(id).get();
		alterado.setIdAlbum(albumAntigo.getIdAlbum());
		albumAntigo = alterado;
		salvar(albumAntigo);
		return AlbumDTO.conversorAlbumDto(albumAntigo);
	}
	
	public void deletar(UUID id) {
		Album album = ar.findById(id).get();
		ar.delete(album);
	}

}
