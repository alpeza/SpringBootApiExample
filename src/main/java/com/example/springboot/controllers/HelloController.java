package com.example.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "<h1>Ejemplo Simple de ApiRest para la gestión de usuarios</h1>";
	}


}
