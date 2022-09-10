package com.example.demo.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.models.Album;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO {

	private String nomeAlbum;
	private Date dataLancamento;
	private Date duracaoAlbum;
	private String imgUrl;
	
	public AlbumDTO(Album obj) {
		this.nomeAlbum = obj.getNomeAlbum();
		this.dataLancamento = obj.getDataLancamento();
		this.duracaoAlbum = obj.getDuracaoAlbum();
		this.imgUrl = obj.getImgUrl();
	}
	
	public static AlbumDTO conversorAlbumDto(Album album){
		AlbumDTO dto = new AlbumDTO(album);
		return dto;
	}
	
	public static List<AlbumDTO> conversorAlbumDto(List<Album> album){
		List<AlbumDTO> dto = album.stream()
				.map(obj -> new AlbumDTO(obj))
				.collect(Collectors.toList());
		return dto;
	}
	
}
