package com.teste_dig.desafio2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teste_dig.desafio2.service.PessoaService;
import com.teste_dig.desafio2.model.Pessoa;
import com.teste_dig.desafio2.model.PessoaBox;

@RestController
@RequestMapping("pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	public ResponseEntity<Object> byId(@RequestBody PessoaBox pessoa) {
		return new ResponseEntity<Object>(this.pessoaService.save(pessoa.getPessoa()), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> byId(@RequestParam long id) {
		return new ResponseEntity<Object>(this.pessoaService.byId(id), HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listAll() {
		return new ResponseEntity<Object>(this.pessoaService.listAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{nome}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> byName(@RequestParam String name) {
		return new ResponseEntity<Object>(this.pessoaService.byName(name), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{salario}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> bySalario(@RequestParam float salario) {
		return new ResponseEntity<Object>(this.pessoaService.bySalario(salario), HttpStatus.OK);
	}
	
	@PutMapping(path = "/{nome}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> bySalario(@RequestParam String nome, @RequestBody Pessoa pessoa) {
		this.pessoaService.update(nome, pessoa);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}

}
