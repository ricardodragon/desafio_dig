package com.teste_dig.desafio2.model;

public class PessoaBox {
	
	private Pessoa pessoa;
	
	public PessoaBox() {	}
	
	public PessoaBox(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
