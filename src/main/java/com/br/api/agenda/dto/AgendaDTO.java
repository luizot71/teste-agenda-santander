package com.br.api.agenda.dto;

import java.io.Serializable;

import com.br.api.agenda.entities.Agenda;

public class AgendaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String dateOfBirth;
	private String cpf;
	
	public AgendaDTO() {
		
	}
	
	public AgendaDTO(Agenda obj) {
		name = obj.getName();
		dateOfBirth = obj.getDateOfBirth();
		cpf = obj.getCpf();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
