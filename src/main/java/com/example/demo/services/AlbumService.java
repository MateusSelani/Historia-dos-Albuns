package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Album;
import com.example.demo.repositories.IAlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	IAlbumRepository ar;
	
	public List<Album> listarTodos() {
		return ar.findAll();
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
		return alterado;
	}
	
	public void deletar(UUID id) {
		ar.deleteById(id);
	}

}
