package com.br.api.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.api.agenda.entities.Endereco;
import com.br.api.agenda.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository end;
	
	public List<Endereco> findAll() {
		
		return end.findAll();
		
	}

}
