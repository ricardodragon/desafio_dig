package com.teste_dig.desafio1.service;

import org.springframework.stereotype.Service;

import com.teste_dig.desafio1.model.Calculadora;

@Service
public class CalculadoraService {	
	private double resultado;
	
	public double calcula(Calculadora calculadora) {
		resultado = 0d;
		
		if(calculadora.getAcao().equals("soma"))
			calculadora.getNumeros().forEach(x -> resultado += x);
		
		else if(calculadora.getAcao().equals("subtrai")) 
			calculadora.getNumeros().forEach(x -> resultado = (resultado==0?x:resultado-x));
		
		else if(calculadora.getAcao().equals("media")) {
			calculadora.getNumeros().forEach(x -> resultado = (resultado==0?x:resultado+x));
			resultado /= calculadora.getNumeros().size();
		}
		
		else if(calculadora.getAcao().equals("total"))
			resultado = Double.valueOf(String.valueOf(calculadora.getNumeros().size()));
		
		return resultado;
	}
	

}
