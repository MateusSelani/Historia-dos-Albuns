package com.example.demo.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.models.Artista;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
	public static ArtistaDTO conversorArtistaDto(Artista artista){
		ArtistaDTO dto = new ArtistaDTO(artista);
		return dto;
	}
	
	public static List<ArtistaDTO> conversorArtistaDto(List<Artista> artista){
		List<ArtistaDTO> dto = artista.stream()
				.map(obj -> new ArtistaDTO(obj))
				.collect(Collectors.toList());
		return dto;
	}
	
	
}
