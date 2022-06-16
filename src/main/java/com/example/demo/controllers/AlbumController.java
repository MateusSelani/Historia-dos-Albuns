package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlbumController {

	@GetMapping
	public String teste() {
		return "hello";
	}
}
