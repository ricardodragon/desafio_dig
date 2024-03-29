package com.teste_dig.desafio2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa implements Serializable{
	
	
	
	public Pessoa() {
		
	}
	public Pessoa(Long i, String nome, Integer idade, Float salario) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer idade;
	private Float salario;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Float getSalario() {
		return salario;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setSalario(Float salario) {
		this.salario = salario;
	}
	
	
}
