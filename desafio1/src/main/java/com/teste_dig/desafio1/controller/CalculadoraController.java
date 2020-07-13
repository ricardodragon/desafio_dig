package com.teste_dig.desafio1.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste_dig.desafio1.model.Calculadora;
import com.teste_dig.desafio1.service.CalculadoraService;

@RestController
@RequestMapping("calculadora")
public class CalculadoraController {

	@Autowired
	private CalculadoraService calculadoraService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	private String calculadora(@RequestBody Calculadora calculadora) throws Exception{			
		return "{\"total\" :"+String.format(Locale.US, "%.2f", this.calculadoraService.calcula(calculadora)) + "}";		
	}
}
