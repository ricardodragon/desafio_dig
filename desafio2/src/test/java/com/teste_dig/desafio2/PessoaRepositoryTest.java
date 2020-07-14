package com.teste_dig.desafio2;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.teste_dig.desafio2.model.Pessoa;
import com.teste_dig.desafio2.repository.PessoaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PessoaRepositoryTest {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test 
	public void createShouldPersistData() {
		Pessoa pessoa = new Pessoa(0L, "James Gosling", 55, 1000.00f);
		this.pessoaRepository.save(pessoa);
		Assertions.assertThat(pessoa.getId());
		Assertions.assertThat(pessoa.getNome()).isEqualTo("James Gosling");
		Assertions.assertThat(pessoa.getIdade()).isEqualTo(55);
		Assertions.assertThat(pessoa.getSalario()).isEqualTo(1000.00f);		
	}
	
	
}
