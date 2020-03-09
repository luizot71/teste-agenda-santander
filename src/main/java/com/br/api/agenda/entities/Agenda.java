package com.br.api.agenda.entities;

public class Agenda {

	private String nome;
	private String dataDeNascimento;
	private String cpf;
	
	public Agenda(String nome, String dataDeNascimento, String cpf) {
		
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return "Agenda [nome=" + nome + ", dataDeNascimento=" + dataDeNascimento + ", cpf=" + cpf + "]";
	}
}
