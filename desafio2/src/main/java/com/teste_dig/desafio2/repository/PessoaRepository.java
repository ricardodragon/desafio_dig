package com.teste_dig.desafio2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste_dig.desafio2.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	List<Pessoa> findByNome(String nome);
	List<Pessoa> findBySalario(Float salario);
}
