package com.example.demo.controller.test;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.example.demo.controllers.ArtistaController;
import com.example.demo.dto.ArtistaDTO;
import com.example.demo.services.AlbumService;
import com.example.demo.services.ArtistaService;
import com.example.demo.services.BandaService;

import io.restassured.http.ContentType;

@WebMvcTest
public class ArtistaControllerTest {
	
	@Autowired
	private ArtistaController artc;
	
	@MockBean
	private ArtistaService arts;

	@MockBean
	private AlbumService as;

	@MockBean
	private BandaService bs;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.artc);
	}
	
	@Test
	public void deveRetornarSucesso_QuandoBuscarArtistas() {
		
		ArrayList<ArtistaDTO> artistas = new ArrayList<ArtistaDTO>();
		ArtistaDTO artista = new ArtistaDTO("nomeArtista", new Date(), "baixista", "usa", "urldeimg");
		artistas.add(artista);
		
		when(this.arts.listarTodos())
		.thenReturn(artistas);
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/artista")
		.then()
			.statusCode(HttpStatus.OK.value());
	}

}
