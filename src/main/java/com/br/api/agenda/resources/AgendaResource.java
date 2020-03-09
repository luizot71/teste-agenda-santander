package com.br.api.agenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.agenda.entities.Agenda;
import com.br.api.agenda.services.AgendaService;

@RestController
@RequestMapping(value="/dados_agenda")
public class AgendaResource {
	
	@Autowired
	private AgendaService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Agenda>> findAll(){
		
		List<Agenda> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}

}
