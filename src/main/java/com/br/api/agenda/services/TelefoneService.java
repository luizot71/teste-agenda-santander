package com.br.api.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.api.agenda.entities.Telefone;
import com.br.api.agenda.repository.TelefoneRepository;

@Service
public class TelefoneService {
	
	@Autowired
	private TelefoneRepository tel;
	
	public List<Telefone> findAll() {
		
		return tel.findAll();
		
	}

}
