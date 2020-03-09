package com.br.api.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.api.agenda.entities.Agenda;
import com.br.api.agenda.repository.AgendaRepository;

@Service
public class AgendaService {
	
	@Autowired
	private AgendaRepository agenda;
	
	public List<Agenda> findAll() {
		
		return agenda.findAll();
		
	}

}
