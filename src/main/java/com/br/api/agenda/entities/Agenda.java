package com.br.api.agenda.entities;

public class Agenda {

	private String name;
	private String dateOfBirth;
	private String cpf;
	
	public Agenda(String name, String dateOfBirth, String cpf) {
		
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.cpf = cpf;
	}
	
	public String getName() {
		return name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return "Agenda [name=" + name + ", dataDeNascimento=" + dateOfBirth + ", cpf=" + cpf + "]";
	}
}
