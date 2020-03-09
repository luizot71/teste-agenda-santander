package com.br.api.agenda.entities;

import java.util.Calendar;

public class Agenda {

	private String nome;
	private Calendar dataDeNascimento;
	private String cpf;
	
	public Agenda(String nome, Calendar dataDeNascimento, String cpf) {
		
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public Calendar getDataDeNascimento() {
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
