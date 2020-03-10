package com.br.api.agenda.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="agenda")
public class Agenda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String dateOfBirth;
	private String cpf;
	
	public Agenda(String id, String name, String dateOfBirth, String cpf) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agenda [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", cpf=" + cpf + "]";
	}

	public String getId() {
		return id;
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

}
