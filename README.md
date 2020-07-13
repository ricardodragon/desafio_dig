-Utilizado h2 como base de dados
# desafio_dig
*
# Desafio1
* Post localhost:8080/calculadora
Body { "acao": acao_value, "numeros": numbers_value } 

# Desafio 2
* Get localhost:8080/pessoa
return array_all_pessoas

* Get localhost:8080/pessoa/id/id_value
return array_all_pessoas_byId

* Get localhost:8080/pessoa/nome/nome_value
return array_all_pessoas_byNome


* Get localhost:8080/pessoa/salario/salario_value
return array_all_pessoas_bySalario


* Post localhost:8080/pessoa
Body { "pessoa": pessoa_objectValue }
Return { pessoa }


* Put localhost:8080/pessoa
Body { "pessoa": pessoa_objectValue }
