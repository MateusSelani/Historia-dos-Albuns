package com.example.demo.dto;

import java.util.Date;

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
	private double duracaoAlbum;
	
	public AlbumDTO(Album obj) {
		this.nomeAlbum = obj.getNomeAlbum();
		this.dataLancamento = obj.getDataLancamento();
		this.duracaoAlbum = obj.getDuracaoAlbum();
	}
	
}
