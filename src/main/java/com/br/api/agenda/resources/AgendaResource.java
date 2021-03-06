package com.br.api.agenda.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.api.agenda.domain.Post;
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
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<AgendaDTO> findById(@PathVariable String id) {
		
		Agenda obj = service.findById(id);
		
		return ResponseEntity.ok().body(new AgendaDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST)
 	public ResponseEntity<Void> insert(@RequestBody AgendaDTO objDto) {
		Agenda obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
 	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
 	public ResponseEntity<Void> update(@RequestBody AgendaDTO objDto, @PathVariable String id) {
		Agenda obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}/posts", method=RequestMethod.GET)
 	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
		Agenda obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getPosts());
	}

}
