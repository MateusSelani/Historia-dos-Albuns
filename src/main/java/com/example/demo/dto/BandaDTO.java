package com.example.demo.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.models.Banda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BandaDTO {

	private String nomeBanda;
	private List<AlbumDTO> albuns;
	private List<ArtistaDTO> artista;
	
	public BandaDTO(Banda obj) {
		this.nomeBanda = obj.getNomeBanda();
		this.artista = conversorArtistaDto(obj);
		this.albuns = conversorAlbumDto(obj);
	}
	
	public static BandaDTO conversorBandaDto(Banda banda) {
		BandaDTO dto = new BandaDTO(banda);
		return dto;
	}
	
	public static List<BandaDTO> conversorBandaDto(List<Banda> banda) {
		List<BandaDTO> dto = banda.stream()
				.map(obj -> new BandaDTO(obj))
				.collect(Collectors.toList());
		return dto;
	}
	
	private List<AlbumDTO> conversorAlbumDto(Banda banda) {
		List<AlbumDTO> listaDto = banda.getAlbum()
				.stream()
				.map(dto -> new AlbumDTO(dto))
				.collect(Collectors.toList());
		return listaDto;
	}
	
	private List<ArtistaDTO> conversorArtistaDto(Banda banda) {
		List<ArtistaDTO> listaDto = banda.getArtistas()
				.stream()
				.map(dto -> new ArtistaDTO(dto))
				.collect(Collectors.toList());
		return listaDto;
	}
	
}
