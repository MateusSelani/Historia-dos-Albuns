package com.example.demo.dto;

import java.util.Date;

import com.example.demo.models.Artista;

import lombok.Data;

@Data
public class ArtistaDTO {

	private String nomeArtista;
	private Date dataNascimento;
	private String funcao;
	private String paisArtista;
	
	public ArtistaDTO(Artista obj) {
		this.nomeArtista = obj.getNomeArtista();
		this.dataNascimento = obj.getDataNascimento();
		this.funcao = obj.getFuncao();
		this.paisArtista = obj.getPaisArtista();
	}
	
}
