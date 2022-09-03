package com.example.demo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "banda")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Banda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idBanda;
	
	@Column(length = 100)
	private String nomeBanda;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataFundacao;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_banda")
//	@JsonManagedReference
	private List<Album> album = new ArrayList<Album>();
	
	@ManyToMany(mappedBy = "bandas", cascade = CascadeType.REMOVE)
	private List<Artista> artistas = new ArrayList<Artista>();
}
