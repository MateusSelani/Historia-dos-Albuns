package com.example.demo.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
@Table(name = "album")
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idAlbum;
	
	@Column(length = 100)
	private String nomeAlbum;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataLancamento;
	
	@Column(length = 10)
	private double duracaoAlbum;
	
	private String descricaoAlbum;
	
	@ManyToOne(targetEntity = Banda.class)
	@JoinColumn(name = "id_banda")
	@JsonBackReference
	private Banda banda;

}
