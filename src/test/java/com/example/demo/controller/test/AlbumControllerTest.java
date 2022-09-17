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

import com.example.demo.controllers.AlbumController;
import com.example.demo.controllers.BandaController;
import com.example.demo.dto.AlbumDTO;
import com.example.demo.services.AlbumService;
import com.example.demo.services.ArtistaService;

import io.restassured.http.ContentType;

@WebMvcTest
public class AlbumControllerTest {
	
	@Autowired
	private AlbumController ac;
	
	@MockBean
	private AlbumService as;

	@MockBean
	private ArtistaService arts;
	
	@MockBean
	private BandaController bc;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.ac);
	}
	
	@Test
	public void deveRetornarSucesso_QuandoBuscarAlbuns() {
		
		ArrayList<AlbumDTO> albuns = new ArrayList<AlbumDTO>();
		AlbumDTO album = new AlbumDTO("albumteste", new Date(), new Date(), "urldeimg");
		albuns.add(album);
		
		when(this.as.listarTodos())
		.thenReturn(albuns);
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/album")
		.then()
			.statusCode(HttpStatus.OK.value());
	}

}
