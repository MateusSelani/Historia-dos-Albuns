package com.example.demo.controller.test;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.example.demo.controllers.AlbumController;
import com.example.demo.controllers.ArtistaController;
import com.example.demo.controllers.BandaController;
import com.example.demo.dto.BandaDTO;
import com.example.demo.services.AlbumService;
import com.example.demo.services.ArtistaService;
import com.example.demo.services.BandaService;

import io.restassured.http.ContentType;

@WebMvcTest
public class BandaControllerTest {
	
	@Autowired
	private BandaController bc;
	
	@MockBean
	private BandaService bs;
	
	@MockBean
	private AlbumController ac;
	
	@MockBean
	private AlbumService as;

	@MockBean
	private ArtistaController artc;
	
	@MockBean
	private ArtistaService arts;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.bc);
	}
	
	@Test
	public void deveRetornarSucesso_QuandoBuscarBandas() {
		
		ArrayList<BandaDTO> bandas = new ArrayList<BandaDTO>();
		BandaDTO banda = new BandaDTO();
		banda.setNomeBanda("teste");
		banda.setImgUrl("url");
		bandas.add(banda);
		
		when(this.bs.listarTodos())
		.thenReturn(bandas);
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/banda")
		.then()
			.statusCode(HttpStatus.OK.value());
	}

}
