package com.example.demo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
	
	private Date dataNascimento;
	
	@Column(length = 100)
	private String funcao;
	
	@Column(length = 100)
	private String paisArtista;
	
	@ManyToMany(targetEntity = Banda.class)
	@JoinTable(name="banda_artista",
    	joinColumns={@JoinColumn(name="id_artista")},
    	inverseJoinColumns={@JoinColumn(name="id_banda")}
	)
	private List<Banda> bandas = new ArrayList<Banda>();
	
}
