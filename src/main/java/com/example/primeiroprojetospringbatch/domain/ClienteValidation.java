package com.example.primeiroprojetospringbatch.domain;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClienteValidation {

	@NotNull
	@Size(min = 1, max = 100)
	private String nome;

	@NotNull
	@Range(min = 18, max = 200)
	private Integer idade;

	@NotNull
	@Size(min = 1, max = 50)
	@Email(message = "Email invalido")
	private String email;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Cliente{" +
                "nome='" + nome + "'" +
                ", idade='" + idade + "'" +
                ", email='" + email + "'" +
                '}';
	}
}
