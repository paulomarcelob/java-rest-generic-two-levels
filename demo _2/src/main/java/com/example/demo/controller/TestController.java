package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TestController {

	@GetMapping("/teste")
	public ResponseEntity<Model<String>> get() {

		Model<String> testeRetorno = new Model<>();
		testeRetorno.setGenerico("Retornei dentro");

		return new ResponseEntity<>(testeRetorno, HttpStatus.OK);
	}
}