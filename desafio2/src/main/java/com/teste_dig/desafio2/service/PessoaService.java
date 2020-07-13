package com.teste_dig.desafio2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste_dig.desafio2.model.Pessoa;
import com.teste_dig.desafio2.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa save(Pessoa pessoa) {
		return this.pessoaRepository.save(pessoa);
	}
	
	public Optional<Pessoa> byId(Long id) {
		return this.pessoaRepository.findById(id);
	}

	public List<Pessoa> listAll() {		
		return this.pessoaRepository.findAll();
	}

	public List<Pessoa> byName(String name) {
		return this.pessoaRepository.findByNome(name);
	}

	public List<Pessoa> bySalario(float salario) {
		return this.pessoaRepository.findBySalario(salario);
	}

	public void update(Pessoa pessoa) {		
		if(pessoa.getId() == null) {
			List<Pessoa> lista = byName(pessoa.getNome());
			lista.forEach(x-> { x.setIdade(pessoa.getIdade()); x.setNome(pessoa.getNome()); x.setSalario(pessoa.getSalario()); } );
			this.pessoaRepository.saveAll(lista);
		}else
			this.pessoaRepository.save(pessoa);		
	}
	
}
