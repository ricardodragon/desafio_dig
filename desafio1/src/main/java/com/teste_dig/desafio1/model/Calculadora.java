package com.teste_dig.desafio1.model;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {

	private String acao;
	private List<Double> numeros = new ArrayList<Double>();
	
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public List<Double> getNumeros() {
		return numeros;
	}
	public void setNumeros(List<Double> numeros) {
		this.numeros = numeros;
	}
	public Calculadora(String acao, List<Double> numeros) {
		super();
		this.acao = acao;
		this.numeros = numeros;
	}
}
