package com.br.api.agenda.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.agenda.dto.AgendaDTO;
import com.br.api.agenda.entities.Agenda;
import com.br.api.agenda.services.AgendaService;

@RestController
@RequestMapping(value="/dados_agenda")
public class AgendaResource {
	
	@Autowired
	private AgendaService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<AgendaDTO>> findAll(){
		
		List<Agenda> list = service.findAll();
		List<AgendaDTO> listDto = list.stream().map(x -> new AgendaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
