package com.teste_dig.desafio2;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.teste_dig.desafio2.model.Pessoa;
import com.teste_dig.desafio2.model.PessoaBox;
import com.teste_dig.desafio2.repository.PessoaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PessoaControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@LocalServerPort
	private int port;
	
	@Before
	public void setup() {
		saveReturnStatusCode200AndBody();
	}
	//@MockBean
	//private PessoaRepository pessoaRepository;
	
	@Test
	public void getByIdReturnStatusCode200() {		
		ResponseEntity<String> response = this.testRestTemplate.getForEntity("/pessoa/id/{id}", String.class, 1L);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void getByNameReturnStatusCode200() {		
		ResponseEntity<String> response = this.testRestTemplate.getForEntity("/pessoa/nome/{nome}", String.class, "James Gosling");
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void listAllReturnStatusCode200() {		
		ResponseEntity<String> response = this.testRestTemplate.getForEntity("/pessoa/nome/{nome}", String.class, "James Gosling");
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void bySalarioReturnStatusCode200() {		
		ResponseEntity<String> response = this.testRestTemplate.getForEntity("/pessoa/nome/{nome}", String.class, "James Gosling");
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void saveReturnStatusCode200AndBody() {		
		PessoaBox pessoa = new PessoaBox(new Pessoa(null,"James Gosling", 55, 1000.00f));
		ResponseEntity<Pessoa> response = this.testRestTemplate.postForEntity("/pessoa", pessoa, Pessoa.class);
		System.out.println(response.getStatusCodeValue());
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
		Assertions.assertThat(response.getBody().getId()).isNotNull();
		Assertions.assertThat(response.getBody().getIdade()).isEqualTo(55);
		Assertions.assertThat(response.getBody().getNome()).isEqualTo("James Gosling");
		Assertions.assertThat(response.getBody().getSalario()).isEqualTo(1000.00f);
	}
	
	@Test
	public void updateReturnStatusCode200() {		
		PessoaBox pessoa = new PessoaBox(new Pessoa(0L,"James Gosling", 55, 1000.00f));
		Pessoa p = this.testRestTemplate.postForEntity("/pessoa", pessoa, Pessoa.class).getBody();
		System.out.println("\n\n\n\n-----Id : ="+p.getId());
		p.setNome("James");
		p.setIdade(56);
		p.setSalario(1003.0f);
		pessoa.setPessoa(p);
		this.testRestTemplate.put("/pessoa", pessoa);
		ResponseEntity<Pessoa> response = this.testRestTemplate.getForEntity("/pessoa/id/{id}", Pessoa.class, p.getId());
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
		Assertions.assertThat(response.getBody().getId()).isNotNull();
		Assertions.assertThat(response.getBody().getIdade()).isEqualTo(56);
		Assertions.assertThat(response.getBody().getNome()).isEqualTo("James");
		Assertions.assertThat(response.getBody().getSalario()).isEqualTo(1003.00f);
	}
}
