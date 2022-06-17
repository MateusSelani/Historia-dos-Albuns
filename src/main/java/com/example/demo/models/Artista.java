package com.example.demo.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "artista")
public class Artista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idArtista;
	
	@Column(length = 100)
	private String nomeArtista;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	@Column(length = 100)
	private String funcao;
	
	@Column(length = 100)
	private String paisArtista;
	
}
