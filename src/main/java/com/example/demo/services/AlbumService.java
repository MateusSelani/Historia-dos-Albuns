package com.example.demo.services;

import java.util.Date;
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
		return AlbumDTO.conversorAlbumDto(albuns);
	}
	
	public AlbumDTO listarUnico(UUID id) {
		Album album = buscarAlbumId(id);
		return AlbumDTO.conversorAlbumDto(album);
	}
	
	public AlbumDTO salvar(Album album) {
		album.setDataCadastro(new Date());
		Album novo = ar.save(album);
		return AlbumDTO.conversorAlbumDto(novo);
	}
	
	public AlbumDTO alterar(UUID id, Album alterado) {
		Album albumAntigo = buscarAlbumId(id);
		alterado.setIdAlbum(albumAntigo.getIdAlbum());
		albumAntigo = alterado;
		salvar(albumAntigo);
		return AlbumDTO.conversorAlbumDto(albumAntigo);
	}
	
	public String deletar(UUID id) {
		Album album = buscarAlbumId(id);
		ar.delete(album);
		return "Album: " + album.getNomeAlbum() + " Deletado!";
	}
	
//	metodo interno
	private Album buscarAlbumId(UUID uuid) {
		return ar.findById(uuid).get();
	}

}
